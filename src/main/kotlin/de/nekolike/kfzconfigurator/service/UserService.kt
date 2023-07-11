package de.nekolike.kfzconfigurator.service

import de.nekolike.kfzconfigurator.dto.UserDTORequest
import de.nekolike.kfzconfigurator.persistence.domain.User
import de.nekolike.kfzconfigurator.persistence.repository.UserRepository
import de.nekolike.kfzconfigurator.result.LoginUserResult
import de.nekolike.kfzconfigurator.result.SaveUserResult
import org.springframework.stereotype.Service

@Service
class UserService(val userRepository: UserRepository) {
    fun saveUser(userDTORequest: UserDTORequest): SaveUserResult {
        if(userRepository.findByUserName(userDTORequest.userDTO.userName).isPresent) {
             return SaveUserResult(false, "User with username ${userDTORequest.userDTO.userName} already exists")
        }
        userRepository.save(
            User(
                userName = userDTORequest.userDTO.userName,
                password = userDTORequest.userDTO.password!!
            )
        )

        return SaveUserResult(true, null)
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