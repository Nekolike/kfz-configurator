package de.nekolike.kfzconfigurator.service

import de.nekolike.kfzconfigurator.dto.ColorDTO
import de.nekolike.kfzconfigurator.persistence.domain.Color
import de.nekolike.kfzconfigurator.persistence.repository.ColorRepository
import org.springframework.stereotype.Service

@Service
class ColorService(val colorRepository: ColorRepository) {
    private fun findColors(): List<Color> = colorRepository.findAll().toList()

    fun getColors(): List<ColorDTO> {
        val colors = findColors()
        val colorDTOs: MutableList<ColorDTO> = mutableListOf()
        for (color in colors) {
            colorDTOs.add(
                ColorDTO(
                    color.color,
                    color.price
                )
            )
        }

        return colorDTOs
    }
}