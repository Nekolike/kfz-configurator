package de.nekolike.kfzconfigurator.repository

import de.nekolike.kfzconfigurator.persistence.EnginePower
import org.springframework.data.jpa.repository.JpaRepository
import java.util.Optional

interface EnginePowerRepository : JpaRepository<EnginePower, Long> {
    fun findByKw(kw: Int) : Optional<EnginePower>

}