package de.nekolike.kfzconfigurator.persistence.repository

import de.nekolike.kfzconfigurator.persistence.domain.CarClass
import org.springframework.data.jpa.repository.JpaRepository
import java.util.Optional

interface CarClassRepository: JpaRepository<CarClass, Long> {
    fun findByCarClass(carClass: String) : Optional<CarClass>
}