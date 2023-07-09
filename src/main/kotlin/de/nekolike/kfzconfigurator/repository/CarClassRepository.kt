package de.nekolike.kfzconfigurator.repository

import de.nekolike.kfzconfigurator.persistence.CarClass
import org.springframework.data.jpa.repository.JpaRepository

interface CarClassRepository: JpaRepository<CarClass, Long>