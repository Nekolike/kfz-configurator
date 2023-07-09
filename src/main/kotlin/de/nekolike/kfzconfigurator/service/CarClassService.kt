package de.nekolike.kfzconfigurator.service

import de.nekolike.kfzconfigurator.dto.CarClassDTO
import de.nekolike.kfzconfigurator.persistence.CarClass
import de.nekolike.kfzconfigurator.repository.CarClassRepository
import org.springframework.stereotype.Service

@Service
class CarClassService(val carClassRepository: CarClassRepository) {
    private fun findCarClasses(): List<CarClass> = carClassRepository.findAll().toList()

    fun getCarClasses(): List<CarClassDTO> {
        val carClasses = findCarClasses()
        val carClassDTOs: MutableList<CarClassDTO> = mutableListOf()
        for (carClass in carClasses) {
            carClassDTOs.add(
                CarClassDTO(
                carClass.carClass,
                carClass.price
            )
            )
        }

        return carClassDTOs
    }
}