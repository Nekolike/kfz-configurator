package de.nekolike.kfzconfigurator.service

import de.nekolike.kfzconfigurator.dto.KfzConfigurationDTO
import de.nekolike.kfzconfigurator.dto.SavedKfzConfigurationDTO
import de.nekolike.kfzconfigurator.dto.SavedKfzConfigurationDTORequest
import de.nekolike.kfzconfigurator.persistence.domain.SavedKfzConfiguration
import de.nekolike.kfzconfigurator.persistence.domain.User
import de.nekolike.kfzconfigurator.persistence.repository.CarClassRepository
import de.nekolike.kfzconfigurator.persistence.repository.CarTypeRepository
import de.nekolike.kfzconfigurator.persistence.repository.ColorRepository
import de.nekolike.kfzconfigurator.persistence.repository.EnginePowerRepository
import de.nekolike.kfzconfigurator.persistence.repository.OptionalEquipmentRepository
import de.nekolike.kfzconfigurator.persistence.repository.SavedKfzConfigurationRepository
import de.nekolike.kfzconfigurator.persistence.repository.UserRepository
import de.nekolike.kfzconfigurator.result.SaveKfzConfigurationResult
import org.springframework.stereotype.Service

@Service
class KfzConfigurationService(
    val carTypeService: CarTypeService,
    val carClassService: CarClassService,
    val colorService: ColorService,
    val enginePowerService: EnginePowerService,
    val optionalEquipmentService: OptionalEquipmentService,
    val carTypeRepository: CarTypeRepository,
    val carClassRepository: CarClassRepository,
    val colorRepository: ColorRepository,
    val enginePowerRepository: EnginePowerRepository,
    val optionalEquipmentRepository: OptionalEquipmentRepository,
    val userRepository: UserRepository,
    val savedKfzConfigurationRepository: SavedKfzConfigurationRepository,
) {
    fun getKfzConfiguration(): KfzConfigurationDTO {
        return KfzConfigurationDTO(
            carTypes = carTypeService.getCarTypes(),
            carClasses = carClassService.getCarClasses(),
            colors = colorService.getColors(),
            enginePowers = enginePowerService.getEnginePowers(),
            optionalEquipment = optionalEquipmentService.getOptionalEquipment()
        )
    }

    fun getSavedKfzConfigurations(userId: Long): MutableList<SavedKfzConfigurationDTO> {
        val savedKfzConfigurations = savedKfzConfigurationRepository.findAllByUser(User(userId, "", "")).get()
        val savedKfzConfigurationDTOs = mutableListOf<SavedKfzConfigurationDTO>()

        for (savedKfzConfiguration in savedKfzConfigurations) {
            savedKfzConfigurationDTOs.add(SavedKfzConfigurationDTO(
                carType = savedKfzConfiguration.carType.carType,
                carClass = savedKfzConfiguration.carClass.carClass,
                color = savedKfzConfiguration.color.color,
                kw = savedKfzConfiguration.enginePower.kw,
                optionalEquipment = savedKfzConfiguration.optionalEquipment.equipment
            ))
        }

        return savedKfzConfigurationDTOs
    }

    fun saveKfzConfiguration(savedKfzConfigurationDTORequest: SavedKfzConfigurationDTORequest): SaveKfzConfigurationResult {
        val savedKfzConfigurationDTO = savedKfzConfigurationDTORequest.savedKfzConfigurationDTO
        val userDTO = savedKfzConfigurationDTORequest.userDTO

        val carType = carTypeRepository.findByCarType(savedKfzConfigurationDTO.carType)
        val carClass = carClassRepository.findByCarClass(savedKfzConfigurationDTO.carClass)
        val color = colorRepository.findByColor(savedKfzConfigurationDTO.color)
        val enginePower = enginePowerRepository.findByKw(savedKfzConfigurationDTO.kw)
        val optionalEquipment = optionalEquipmentRepository.findByEquipment(savedKfzConfigurationDTO.optionalEquipment)
        val user = userRepository.findByUserName(userDTO.userName)

        try {
            val kfzConfigurationToSave = SavedKfzConfiguration(
                carType = carType.get(),
                carClass = carClass.get(),
                color = color.get(),
                enginePower = enginePower.get(),
                optionalEquipment = optionalEquipment.get(),
                user = user.get()
            )

            savedKfzConfigurationRepository.save(kfzConfigurationToSave)
        } catch (ex: NoSuchElementException) {
            return SaveKfzConfigurationResult(false, "Couldn't save kfz configuration since one or more configuration items aren't valid options")
        }

        return SaveKfzConfigurationResult(true, null)
    }
}