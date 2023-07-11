package de.nekolike.kfzconfigurator.service

import de.nekolike.kfzconfigurator.dto.OptionalEquipmentDTO
import de.nekolike.kfzconfigurator.persistence.domain.OptionalEquipment
import de.nekolike.kfzconfigurator.persistence.repository.OptionalEquipmentRepository
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