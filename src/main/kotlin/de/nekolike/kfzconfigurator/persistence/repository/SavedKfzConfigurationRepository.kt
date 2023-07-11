package de.nekolike.kfzconfigurator.persistence.repository

import de.nekolike.kfzconfigurator.persistence.domain.SavedKfzConfiguration
import de.nekolike.kfzconfigurator.persistence.domain.User
import org.springframework.data.jpa.repository.JpaRepository
import java.util.Optional

interface SavedKfzConfigurationRepository : JpaRepository<SavedKfzConfiguration, Long> {
    fun findAllByUser(user: User) : Optional<List<SavedKfzConfiguration>>
}