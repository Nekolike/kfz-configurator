package de.nekolike.kfzconfigurator.persistence

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "engine_power")
class EnginePower(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "engine_power_id")
    val enginePowerId: Long,

    val kw: Int,

    val price: Int
)