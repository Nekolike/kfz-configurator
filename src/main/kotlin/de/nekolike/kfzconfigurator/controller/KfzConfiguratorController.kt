package de.nekolike.kfzconfigurator.controller

import de.nekolike.kfzconfigurator.service.KfzConfigurationService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class KfzConfiguratorController(
    val kfzConfigurationService: KfzConfigurationService,
)
{
    @GetMapping("/kfzConfiguration")
    fun getKfzConfiguration() = kfzConfigurationService.getKfzConfiguration()
}