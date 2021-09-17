package com.supper.generator.randomizer

interface Randomizer<T> {
    fun getRandom(vararg value: Any): T
}