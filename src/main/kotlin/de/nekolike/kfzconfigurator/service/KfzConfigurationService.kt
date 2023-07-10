package de.nekolike.kfzconfigurator.service

import de.nekolike.kfzconfigurator.dto.KfzConfigurationDTO
import org.springframework.stereotype.Service

@Service
class KfzConfigurationService(
    val carTypeService: CarTypeService,
    val carClassService: CarClassService,
    val colorService: ColorService,
    val enginePowerService: EnginePowerService,
    val optionalEquipmentService: OptionalEquipmentService,
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
}