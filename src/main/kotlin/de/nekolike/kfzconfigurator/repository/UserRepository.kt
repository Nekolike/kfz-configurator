package de.nekolike.kfzconfigurator.repository

import de.nekolike.kfzconfigurator.persistence.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
interface UserRepository : JpaRepository<User, Long> {
    fun findByUserName(userName: String) : Optional<User>
}