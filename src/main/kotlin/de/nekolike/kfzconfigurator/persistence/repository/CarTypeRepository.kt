package de.nekolike.kfzconfigurator.persistence.repository

import de.nekolike.kfzconfigurator.persistence.domain.CarType
import org.springframework.data.jpa.repository.JpaRepository
import java.util.Optional

interface CarTypeRepository : JpaRepository<CarType, Long> {
    fun findByCarType(carType: String) : Optional<CarType>
}