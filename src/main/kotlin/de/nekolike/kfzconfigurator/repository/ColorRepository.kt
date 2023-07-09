package de.nekolike.kfzconfigurator.repository

import de.nekolike.kfzconfigurator.persistence.Color
import org.springframework.data.jpa.repository.JpaRepository

interface ColorRepository : JpaRepository<Color, Long>