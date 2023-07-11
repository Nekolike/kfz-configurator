package de.nekolike.kfzconfigurator.repository

import de.nekolike.kfzconfigurator.persistence.SavedKfzConfiguration
import de.nekolike.kfzconfigurator.persistence.User
import org.springframework.data.jpa.repository.JpaRepository
import java.util.Optional

interface SavedKfzConfigurationRepository : JpaRepository<SavedKfzConfiguration, Long> {
    fun findAllByUser(user: User) : Optional<List<SavedKfzConfiguration>>
}