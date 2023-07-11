package de.nekolike.kfzconfigurator.repository

import de.nekolike.kfzconfigurator.persistence.Color
import org.springframework.data.jpa.repository.JpaRepository
import java.util.Optional

interface ColorRepository : JpaRepository<Color, Long> {
    fun findByColor(color: String) : Optional<Color>
}