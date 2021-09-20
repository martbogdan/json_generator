package com.supper.randomizer

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class RandomizerApplication

fun main(args: Array<String>) {
    runApplication<RandomizerApplication>(*args)
}
