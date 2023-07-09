package de.nekolike.kfzconfigurator.controller

import de.nekolike.kfzconfigurator.dto.KfzConfigurationDTO
import de.nekolike.kfzconfigurator.service.CarClassService
import de.nekolike.kfzconfigurator.service.CarTypeService
import de.nekolike.kfzconfigurator.service.ColorService
import de.nekolike.kfzconfigurator.service.EnginePowerService
import de.nekolike.kfzconfigurator.service.OptionalEquipmentService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class KfzConfiguratorController(
    val carTypeService: CarTypeService,
    val carClassService: CarClassService,
    val colorService: ColorService,
    val enginePowerService: EnginePowerService,
    val optionalEquipmentService: OptionalEquipmentService,
)
{
    @GetMapping("/kfzconfiguration")
    fun getKfzConfiguration() = KfzConfigurationDTO(
        carTypes = carTypeService.getCarTypes(),
        carClasses = carClassService.getCarClasses(),
        colors = colorService.getColors(),
        enginePowers = enginePowerService.getEnginePowers(),
        optionalEquipment = optionalEquipmentService.getOptionalEquipment()
    )
}