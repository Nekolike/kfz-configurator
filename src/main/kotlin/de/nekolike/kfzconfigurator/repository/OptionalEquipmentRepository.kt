package de.nekolike.kfzconfigurator.repository

import de.nekolike.kfzconfigurator.persistence.OptionalEquipment
import org.springframework.data.jpa.repository.JpaRepository
import java.util.Optional

interface OptionalEquipmentRepository : JpaRepository<OptionalEquipment, Long> {
    fun findByEquipment(equipment: String) : Optional<OptionalEquipment>
}