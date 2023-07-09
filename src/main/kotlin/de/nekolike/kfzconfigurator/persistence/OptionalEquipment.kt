package de.nekolike.kfzconfigurator.persistence

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "optional_equipment")
data class OptionalEquipment(
    @Id
    val id: Long,

    val equipment: String,

    val price: Int
)
