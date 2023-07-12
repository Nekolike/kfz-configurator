package de.nekolike.kfzconfigurator.service

import de.nekolike.kfzconfigurator.dto.KfzConfigurationDTO
import de.nekolike.kfzconfigurator.dto.SavedKfzConfigurationDTO
import de.nekolike.kfzconfigurator.dto.SavedKfzConfigurationDTORequest
import de.nekolike.kfzconfigurator.persistence.domain.OptionalEquipment
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
            val setOfOptionalEquipment: MutableSet<String> = mutableSetOf()
            for(optionalEquipment in savedKfzConfiguration.optionalEquipment) {
                setOfOptionalEquipment.add(optionalEquipment.equipment)
            }

            savedKfzConfigurationDTOs.add(SavedKfzConfigurationDTO(
                carType = savedKfzConfiguration.carType.carType,
                carClass = savedKfzConfiguration.carClass.carClass,
                color = savedKfzConfiguration.color.color,
                kw = savedKfzConfiguration.enginePower.kw,
                optionalEquipment = setOfOptionalEquipment,
            ))
        }

        return savedKfzConfigurationDTOs
    }

    fun saveKfzConfiguration(savedKfzConfigurationDTORequest: SavedKfzConfigurationDTORequest): SaveKfzConfigurationResult {
        val kfzConfigurationToSave = try {
            createKfzConfigurationToSave(savedKfzConfigurationDTORequest)
        } catch (ex: NoSuchElementException) {
            return SaveKfzConfigurationResult(false, "Couldn't save kfz configuration since one or more configuration items aren't valid options")
        }

        val result = savedKfzConfigurationRepository.save(kfzConfigurationToSave)

        return SaveKfzConfigurationResult(success = true, savedKfzConfigurationId = result.savedKfzConfigurationId)
    }

    fun updateKfzConfiguration(savedKfzConfigurationDTORequest: SavedKfzConfigurationDTORequest, savedKfzConfigurationId: Long): SaveKfzConfigurationResult {
        val kfzConfigurationToSave = try {
             createKfzConfigurationToSave(savedKfzConfigurationDTORequest, savedKfzConfigurationId)
        } catch (ex: NoSuchElementException) {
            return SaveKfzConfigurationResult(false, "Couldn't save kfz configuration since one or more configuration items aren't valid options")
        }

        val result = savedKfzConfigurationRepository.save(kfzConfigurationToSave)

        return SaveKfzConfigurationResult(success = true, savedKfzConfigurationId = result.savedKfzConfigurationId)
    }

    private fun createKfzConfigurationToSave(savedKfzConfigurationDTORequest: SavedKfzConfigurationDTORequest): SavedKfzConfiguration {
        return createKfzConfigurationToSave(savedKfzConfigurationDTORequest, null)
    }

    private fun createKfzConfigurationToSave(savedKfzConfigurationDTORequest: SavedKfzConfigurationDTORequest, savedKfzConfigurationId: Long?): SavedKfzConfiguration {
        val savedKfzConfigurationDTO = savedKfzConfigurationDTORequest.savedKfzConfigurationDTO
        val userDTO = savedKfzConfigurationDTORequest.userDTO

        val carType = carTypeRepository.findByCarType(savedKfzConfigurationDTO.carType)
        val carClass = carClassRepository.findByCarClass(savedKfzConfigurationDTO.carClass)
        val color = colorRepository.findByColor(savedKfzConfigurationDTO.color)
        val enginePower = enginePowerRepository.findByKw(savedKfzConfigurationDTO.kw)

        val setOfOptionalEquipment: MutableSet<OptionalEquipment> = mutableSetOf()
        for (optionalEquipment in savedKfzConfigurationDTO.optionalEquipment) {
            setOfOptionalEquipment.add(optionalEquipmentRepository.findByEquipment(optionalEquipment).get())
        }

        val user = userRepository.findByUserName(userDTO.userName)

        val result = try {
            val savedKfzConfiguration = SavedKfzConfiguration(
                savedKfzConfigurationId = savedKfzConfigurationId,
                carType = carType.get(),
                carClass = carClass.get(),
                color = color.get(),
                enginePower = enginePower.get(),
                user = user.get()
            )

            for (optionalEquipment in setOfOptionalEquipment) {
                savedKfzConfiguration.optionalEquipment.add(optionalEquipment)
            }

            savedKfzConfiguration
        } catch (ex: NoSuchElementException) {
            throw  NoSuchElementException()
        }

        return result
    }
}