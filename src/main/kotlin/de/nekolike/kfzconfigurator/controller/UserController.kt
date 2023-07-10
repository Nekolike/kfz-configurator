package de.nekolike.kfzconfigurator.controller

import de.nekolike.kfzconfigurator.dto.UserDTORequest
import de.nekolike.kfzconfigurator.result.LoginUserResult
import de.nekolike.kfzconfigurator.result.SaveUserResult
import de.nekolike.kfzconfigurator.service.UserService
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController(
    val userService: UserService,
) {
    @PostMapping("/saveUser")
    fun saveUser(
        @RequestBody @Validated
        request: UserDTORequest
    ): ResponseEntity<SaveUserResult> {
        val saveResult = userService.saveUser(request)
        return ResponseEntity.ok(saveResult)
    }

    @PostMapping("/loginUser")
    fun loginUser(
        @RequestBody @Validated
        request: UserDTORequest
    ): ResponseEntity<LoginUserResult> {
        val loginUserResult = userService.canLoginUser(request)
        return ResponseEntity.ok(loginUserResult)
    }
}