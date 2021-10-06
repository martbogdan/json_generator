package com.supper.customfaker

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CustomFakerApplication

fun main(args: Array<String>) {
    runApplication<CustomFakerApplication>(*args)
}
