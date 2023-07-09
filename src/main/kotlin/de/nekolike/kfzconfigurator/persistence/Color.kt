package de.nekolike.kfzconfigurator.persistence

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "colors")
data class Color(
    @Id
    val id: Long,

    val color: String,

    val price: Int
)