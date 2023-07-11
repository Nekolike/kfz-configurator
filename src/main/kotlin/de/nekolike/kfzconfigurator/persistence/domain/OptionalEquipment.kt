package de.nekolike.kfzconfigurator.persistence.domain

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "optional_equipment")
data class OptionalEquipment(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "optional_equipment_id")
    val optionalEquipmentId: Long,

    val equipment: String,

    val price: Int
)
