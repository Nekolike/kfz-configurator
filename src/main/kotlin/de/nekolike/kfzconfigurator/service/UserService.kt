package de.nekolike.kfzconfigurator.service

import de.nekolike.kfzconfigurator.dto.UserDTORequest
import de.nekolike.kfzconfigurator.persistence.domain.User
import de.nekolike.kfzconfigurator.persistence.repository.UserRepository
import de.nekolike.kfzconfigurator.result.LoginUserResult
import de.nekolike.kfzconfigurator.result.RegisterUserResult
import org.springframework.stereotype.Service

@Service
class UserService(val userRepository: UserRepository) {
    fun registerUser(userDTORequest: UserDTORequest): RegisterUserResult {
        if(userRepository.findByUserName(userDTORequest.userDTO.userName).isPresent) {
             return RegisterUserResult(false, "User with username ${userDTORequest.userDTO.userName} already exists", null)
        }
        val newUser = userRepository.save(
            User(
                userName = userDTORequest.userDTO.userName,
                password = userDTORequest.userDTO.password!!
            )
        )

        return RegisterUserResult(true, null, newUser.userId)
    }

    fun canLoginUser(userDTORequest: UserDTORequest): LoginUserResult {
        val optionalUser = userRepository.findByUserName(userDTORequest.userDTO.userName)
        if(optionalUser.isEmpty) {
            return LoginUserResult(false, "User with username ${userDTORequest.userDTO.userName} doesn't exist", null)
        } else if(optionalUser.get().password != userDTORequest.userDTO.password) {
            return LoginUserResult(false, "Password is incorrect", null)
        }

        return LoginUserResult(true, null, optionalUser.get().userId)
    }
}