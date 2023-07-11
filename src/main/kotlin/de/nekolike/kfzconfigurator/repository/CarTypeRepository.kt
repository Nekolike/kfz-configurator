package de.nekolike.kfzconfigurator.repository

import de.nekolike.kfzconfigurator.persistence.CarType
import org.springframework.data.jpa.repository.JpaRepository
import java.util.Optional

interface CarTypeRepository : JpaRepository<CarType, Long> {
    fun findByCarType(carType: String) : Optional<CarType>
}