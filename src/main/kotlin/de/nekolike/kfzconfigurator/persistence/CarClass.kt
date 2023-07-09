package de.nekolike.kfzconfigurator.persistence

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "car_classes")
data class CarClass(
    @Id
    val id: Long,

    @Column(name = "car_class")
    val carClass: String,

    val price: Int
)