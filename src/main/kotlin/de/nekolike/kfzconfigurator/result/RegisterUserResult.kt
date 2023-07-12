package de.nekolike.kfzconfigurator.result

data class RegisterUserResult(
    val success: Boolean,
    val errorMessage: String?,
    val userId: Long?
)
