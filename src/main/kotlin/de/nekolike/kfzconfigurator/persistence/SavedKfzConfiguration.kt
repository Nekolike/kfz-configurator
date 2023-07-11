package de.nekolike.kfzconfigurator.persistence

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table

@Entity
@Table(name = "saved_kfz_configurations")
data class SavedKfzConfiguration(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "saved_kfz_configuration_id")
    val savedKfzConfigurationId: Long?=null,

    @ManyToOne
    @JoinColumn(name = "car_class_id")
    val carClass: CarClass,

    @ManyToOne
    @JoinColumn(name = "car_type_id")
    val carType: CarType,

    @ManyToOne
    @JoinColumn(name = "color_id")
    val color: Color,

    @ManyToOne
    @JoinColumn(name = "engine_power_id")
    val enginePower: EnginePower,

    @ManyToOne
    @JoinColumn(name = "optional_equipment_id")
    val optionalEquipment: OptionalEquipment,

    @ManyToOne
    @JoinColumn(name = "user_id")
    val user: User
)
