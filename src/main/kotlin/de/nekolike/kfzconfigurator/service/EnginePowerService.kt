package de.nekolike.kfzconfigurator.service

import de.nekolike.kfzconfigurator.dto.EnginePowerDTO
import de.nekolike.kfzconfigurator.persistence.EnginePower
import de.nekolike.kfzconfigurator.repository.EnginePowerRepository
import org.springframework.stereotype.Service

@Service
class EnginePowerService(val enginePowerRepository: EnginePowerRepository) {
    private fun findEnginePowers(): List<EnginePower> = enginePowerRepository.findAll().toList()

    fun getEnginePowers(): List<EnginePowerDTO> {
        val enginePowers = findEnginePowers()
        val enginePowerDTOs: MutableList<EnginePowerDTO> = mutableListOf()
        for (enginePower in enginePowers) {
            enginePowerDTOs.add(
                EnginePowerDTO(
                    enginePower.kw,
                    enginePower.price
                )
            )
        }

        return enginePowerDTOs
    }
}