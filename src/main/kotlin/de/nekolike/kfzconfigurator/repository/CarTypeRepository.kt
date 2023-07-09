package de.nekolike.kfzconfigurator.repository

import de.nekolike.kfzconfigurator.persistence.CarType
import org.springframework.data.jpa.repository.JpaRepository

interface CarTypeRepository : JpaRepository<CarType, Long>