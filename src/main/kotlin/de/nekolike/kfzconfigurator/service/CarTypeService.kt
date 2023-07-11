package de.nekolike.kfzconfigurator.service

import de.nekolike.kfzconfigurator.dto.CarTypeDTO
import de.nekolike.kfzconfigurator.persistence.domain.CarType
import de.nekolike.kfzconfigurator.persistence.repository.CarTypeRepository
import org.springframework.stereotype.Service

@Service
class CarTypeService(val carTypeRepository: CarTypeRepository) {
    private fun findCarTypes(): List<CarType> = carTypeRepository.findAll().toList()

    fun getCarTypes(): List<CarTypeDTO> {
        val carTypes = findCarTypes()
        val carTypeDTOs: MutableList<CarTypeDTO> = mutableListOf()
        for (carType in carTypes) {
            carTypeDTOs.add(CarTypeDTO(
                carType.carType,
                carType.price
            ))
        }

        return carTypeDTOs
    }
}