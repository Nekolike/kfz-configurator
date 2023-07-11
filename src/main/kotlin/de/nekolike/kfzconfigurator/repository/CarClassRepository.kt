package de.nekolike.kfzconfigurator.repository

import de.nekolike.kfzconfigurator.persistence.CarClass
import org.springframework.data.jpa.repository.JpaRepository
import java.util.Optional

interface CarClassRepository: JpaRepository<CarClass, Long> {
    fun findByCarClass(carClass: String) : Optional<CarClass>
}