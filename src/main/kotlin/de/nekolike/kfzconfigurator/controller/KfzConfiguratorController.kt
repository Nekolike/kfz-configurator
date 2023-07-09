package de.nekolike.kfzconfigurator.controller

import de.nekolike.kfzconfigurator.dto.CarClassDTO
import de.nekolike.kfzconfigurator.dto.CarTypeDTO
import de.nekolike.kfzconfigurator.dto.ColorDTO
import de.nekolike.kfzconfigurator.service.CarClassService
import de.nekolike.kfzconfigurator.service.CarTypeService
import de.nekolike.kfzconfigurator.service.ColorService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class KfzConfiguratorController(
    val carTypeService: CarTypeService,
    val carClassService: CarClassService,
    val colorService: ColorService,
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
}