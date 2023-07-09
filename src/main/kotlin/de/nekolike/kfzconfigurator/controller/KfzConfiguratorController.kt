package de.nekolike.kfzconfigurator.controller

import de.nekolike.kfzconfigurator.dto.CarClassDTO
import de.nekolike.kfzconfigurator.dto.CarTypeDTO
import de.nekolike.kfzconfigurator.dto.ColorDTO
import de.nekolike.kfzconfigurator.dto.EnginePowerDTO
import de.nekolike.kfzconfigurator.dto.OptionalEquipmentDTO
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
    @GetMapping("/cartypes")
    fun getCarTypes(): List<CarTypeDTO> {
        return carTypeService.getCarTypes()
    }

    @GetMapping("/carclasses")
    fun getCarClasses(): List<CarClassDTO> {
        return carClassService.getCarClasses()
    }

    @GetMapping("/colors")
    fun getColors(): List<ColorDTO> {
        return colorService.getColors()
    }

    @GetMapping("/enginepowers")
    fun getEnginePowers(): List<EnginePowerDTO> {
        return enginePowerService.getEnginePowers()
    }

    @GetMapping("/optionalequipment")
    fun getOptionalEquipment(): List<OptionalEquipmentDTO> {
        return optionalEquipmentService.getOptionalEquipment()
    }
}