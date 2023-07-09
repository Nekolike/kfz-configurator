package de.nekolike.kfzconfigurator.service

import de.nekolike.kfzconfigurator.dto.OptionalEquipmentDTO
import de.nekolike.kfzconfigurator.persistence.OptionalEquipment
import de.nekolike.kfzconfigurator.repository.OptionalEquipmentRepository
import org.springframework.stereotype.Service

@Service
class OptionalEquipmentService(val optionalEquipmentRepository: OptionalEquipmentRepository) {
    private fun findOptionalEquipment(): List<OptionalEquipment> = optionalEquipmentRepository.findAll().toList()

    fun getOptionalEquipment(): List<OptionalEquipmentDTO> {
        val optionalEquipment = findOptionalEquipment()
        val optionalEquipmentDTOs: MutableList<OptionalEquipmentDTO> = mutableListOf()
        for (optEquipment in optionalEquipment) {
            optionalEquipmentDTOs.add(
                OptionalEquipmentDTO(
                    optEquipment.equipment,
                    optEquipment.price
                )
            )
        }

        return optionalEquipmentDTOs
    }
}