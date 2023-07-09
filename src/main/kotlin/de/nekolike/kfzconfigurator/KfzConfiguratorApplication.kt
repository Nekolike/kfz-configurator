package de.nekolike.kfzconfigurator

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KfzConfiguratorApplication

fun main(args: Array<String>) {
	runApplication<KfzConfiguratorApplication>(*args)
}
