package de.nekolike.kfzconfigurator.dto

data class KfzConfigurationDTO(
    val carTypes: List<CarTypeDTO>,
    val carClasses: List<CarClassDTO>,
    val colors: List<ColorDTO>,
    val enginePowers: List<EnginePowerDTO>,
    val optionalEquipment: List<OptionalEquipmentDTO>,
)
