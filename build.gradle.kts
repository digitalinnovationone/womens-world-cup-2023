/*
 * This project was generated using the Spring Initializr. For more details, visit the following URL:
 * https://start.spring.io/#!type=gradle-project-kotlin&language=kotlin&platformVersion=3.1.1&packaging=jar&jvmVersion=17&groupId=me.dio&artifactId=womens-world-cup-2023&name=womens-world-cup-2023&description=Women's%20World%20Cup%202023%20RESTful%20API&packageName=me.dio.wwc&dependencies=web,data-jpa,h2,postgresql
 */

import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "3.1.1"
	id("io.spring.dependency-management") version "1.1.0"
	kotlin("jvm") version "1.8.22"
	kotlin("plugin.spring") version "1.8.22"
	kotlin("plugin.jpa") version "1.8.22"
}

group = "me.dio"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_17
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.1.0")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")

	runtimeOnly("com.h2database:h2")
	runtimeOnly("org.postgresql:postgresql")

	testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs += "-Xjsr305=strict"
		jvmTarget = "17"
	}
}

tasks.jar {
	manifest.attributes["Main-Class"] = "me.dio.wwc.Application"
}

tasks.withType<Test> {
	useJUnitPlatform()
}
