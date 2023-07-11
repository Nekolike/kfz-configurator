package de.nekolike.kfzconfigurator.persistence.repository

import de.nekolike.kfzconfigurator.persistence.domain.OptionalEquipment
import org.springframework.data.jpa.repository.JpaRepository
import java.util.Optional

interface OptionalEquipmentRepository : JpaRepository<OptionalEquipment, Long> {
    fun findByEquipment(equipment: String) : Optional<OptionalEquipment>
}