package de.nekolike.kfzconfigurator.service

import de.nekolike.kfzconfigurator.persistence.CarType
import de.nekolike.kfzconfigurator.repository.CarTypeRepository
import org.springframework.stereotype.Service

@Service
class CarTypeService(val carTypeRepository: CarTypeRepository) {
    fun findCarTypes(): List<CarType> = carTypeRepository.findAll().toList()
}