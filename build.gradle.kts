import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "3.1.1"
	id("io.spring.dependency-management") version "1.1.0"
	id("com.avast.gradle.docker-compose") version "0.16.12"
	id("com.google.cloud.tools.jib") version "3.3.1"
	kotlin("jvm") version "1.8.22"
	kotlin("plugin.spring") version "1.8.22"
	kotlin("plugin.jpa") version "1.8.22"
}

group = "de.nekolike"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_17
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-actuator")
	implementation("org.springframework.boot:spring-boot-starter-data-jdbc")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-jdbc")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.flywaydb:flyway-core")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.postgresql:postgresql:42.5.4")
	implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.0.0")
	developmentOnly("org.springframework.boot:spring-boot-devtools")
	runtimeOnly("io.micrometer:micrometer-registry-prometheus")
	runtimeOnly("com.h2database:h2")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs += "-Xjsr305=strict"
		jvmTarget = "17"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}

jib {
	var tag = "latest"
	from {
		image = "openjdk:17-oracle"
	}
	to {
		image = "registry.hub.docker.com/nekolike/kfz-configurator"
		tags = setOf(version, tag) as MutableSet<String>
	}
	container {
		jvmFlags = listOf(
			"-server",
			"-Duser.timezone=UTC",
			"-Xms128m",
			"-Xmx1g"
		)
	}
}