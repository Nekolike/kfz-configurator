package de.nekolike.kfzconfigurator.result

data class LoginUserResult(
    val success: Boolean,
    val errorMessage: String?,
    val userId: Long?
)
