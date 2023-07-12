package de.nekolike.kfzconfigurator.dto

data class SavedKfzConfigurationDTO(
    val carClass: String,
    val carType: String,
    val color: String,
    val kw: Int,
    val optionalEquipment: Set<String>,
)

data class SavedKfzConfigurationDTORequest(
    val savedKfzConfigurationDTO: SavedKfzConfigurationDTO,
    val userDTO: UserDTO
)