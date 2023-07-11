package de.nekolike.kfzconfigurator.result

data class SaveKfzConfigurationResult(
    val success: Boolean,
    val errorMessage: String?
)