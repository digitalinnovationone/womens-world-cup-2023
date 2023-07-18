package me.dio.wwc

import io.swagger.v3.oas.annotations.OpenAPIDefinition
import io.swagger.v3.oas.annotations.servers.Server
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

/**
 * Initializes our RESTful API.
 *
 * The [OpenAPIDefinition] annotation was used to enable HTTPS in the Swagger UI.
 * For more details, see the following post on Stack Overflow:
 * https://stackoverflow.com/a/71132608/3072570
 */
@OpenAPIDefinition(servers = [Server(url = "/", description = "Default Server URL")])
@EnableFeignClients
@SpringBootApplication
class Application

fun main(args: Array<String>) {
    runApplication<Application>(*args)
}
