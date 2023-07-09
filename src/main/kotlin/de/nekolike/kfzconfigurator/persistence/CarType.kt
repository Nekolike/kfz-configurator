package de.nekolike.kfzconfigurator.persistence

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "car_types")
data class CarType(
    @Id
    val id: Long,

    @Column(name = "car_type")
    val carType: String,

    val price: Int
)