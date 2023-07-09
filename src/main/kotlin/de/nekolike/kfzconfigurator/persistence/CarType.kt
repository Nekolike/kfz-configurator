package de.nekolike.kfzconfigurator.persistence

import jakarta.persistence.Entity
import jakarta.persistence.Id

@Entity
data class CarType(
    @Id
    val id: Long,

    val type: String,

    val price: Long
)