package de.nekolike.kfzconfigurator.controller

import de.nekolike.kfzconfigurator.dto.CarTypeDTO
import de.nekolike.kfzconfigurator.service.CarTypeService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class KfzConfiguratorController(val carTypeService: CarTypeService) {
    @GetMapping("/")
    fun getCarTypes(): List<CarTypeDTO> {
        return carTypeService.getCarTypes()
    }
}