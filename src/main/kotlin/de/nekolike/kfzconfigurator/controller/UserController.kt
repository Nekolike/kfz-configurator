package de.nekolike.kfzconfigurator.controller

import de.nekolike.kfzconfigurator.dto.UserDTORequest
import de.nekolike.kfzconfigurator.result.LoginUserResult
import de.nekolike.kfzconfigurator.result.RegisterUserResult
import de.nekolike.kfzconfigurator.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController(
    val userService: UserService,
) {
    @PostMapping("/registerUser")
    fun saveUser(
        @RequestBody @Validated
        request: UserDTORequest
    ): ResponseEntity<RegisterUserResult> {
        val saveResult = userService.registerUser(request)

        return if(saveResult.success) {
            ResponseEntity.status(HttpStatus.CREATED).body(saveResult)
        } else {
            ResponseEntity.status(HttpStatus.CONFLICT).body(saveResult)
        }
    }

    @PostMapping("/loginUser")
    fun loginUser(
        @RequestBody @Validated
        request: UserDTORequest
    ): ResponseEntity<LoginUserResult> {
        val loginUserResult = userService.canLoginUser(request)

        return if(loginUserResult.success) {
            ResponseEntity.status(HttpStatus.OK).body(loginUserResult)
        } else {
            ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(loginUserResult)
        }
    }
}