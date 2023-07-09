package de.nekolike.kfzconfigurator.persistence

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "engine_power")
class EnginePower(
    @Id
    val id: Long,

    val kw: Int,

    val price: Int
)