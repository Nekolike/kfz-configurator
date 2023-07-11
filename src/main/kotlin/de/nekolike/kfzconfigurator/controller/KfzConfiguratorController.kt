package de.nekolike.kfzconfigurator.controller

import de.nekolike.kfzconfigurator.dto.SavedKfzConfigurationDTORequest
import de.nekolike.kfzconfigurator.result.SaveKfzConfigurationResult
import de.nekolike.kfzconfigurator.service.KfzConfigurationService
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class KfzConfiguratorController(
    val kfzConfigurationService: KfzConfigurationService,
)
{
    @GetMapping("/kfzConfiguration")
    fun getKfzConfiguration() = kfzConfigurationService.getKfzConfiguration()

    @GetMapping("/savedKfzConfiguration/{userId}")
    fun getSavedKfzConfigurations(@PathVariable userId: Long) = kfzConfigurationService.getSavedKfzConfigurations(userId)

    @PostMapping("/saveConfiguration")
    fun saveKfzConfiguration(
        @RequestBody @Validated
        request: SavedKfzConfigurationDTORequest
    ): ResponseEntity<SaveKfzConfigurationResult> {
        val saveResult = kfzConfigurationService.saveKfzConfiguration(request)
        return ResponseEntity.ok(saveResult)
    }
}