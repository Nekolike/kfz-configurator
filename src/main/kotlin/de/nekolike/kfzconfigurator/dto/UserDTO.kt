package de.nekolike.kfzconfigurator.dto

data class UserDTO(
    val userName: String,
    val password: String
)

data class UserDTORequest(
    val userDTO: UserDTO
)