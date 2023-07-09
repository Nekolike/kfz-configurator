package de.nekolike.kfzconfigurator.repository

import de.nekolike.kfzconfigurator.persistence.EnginePower
import org.springframework.data.jpa.repository.JpaRepository

interface EnginePowerRepository : JpaRepository<EnginePower, Long>