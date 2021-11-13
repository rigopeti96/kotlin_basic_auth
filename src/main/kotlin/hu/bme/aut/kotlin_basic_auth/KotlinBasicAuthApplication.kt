package hu.bme.aut.kotlin_basic_auth

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KotlinBasicAuthApplication

fun main(args: Array<String>) {
    runApplication<KotlinBasicAuthApplication>(*args)
}
