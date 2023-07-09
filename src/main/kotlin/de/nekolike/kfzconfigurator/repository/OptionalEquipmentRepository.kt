package de.nekolike.kfzconfigurator.repository

import de.nekolike.kfzconfigurator.persistence.OptionalEquipment
import org.springframework.data.jpa.repository.JpaRepository

interface OptionalEquipmentRepository : JpaRepository<OptionalEquipment, Long>