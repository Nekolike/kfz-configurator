package de.nekolike.kfzconfigurator.persistence.domain

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "car_classes")
data class CarClass(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "car_class_id")
    val carClassId: Long,

    @Column(name = "car_class")
    val carClass: String,

    val price: Int
)