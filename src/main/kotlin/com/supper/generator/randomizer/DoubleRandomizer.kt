package com.supper.generator.randomizer

import kotlin.random.Random

interface DoubleRandomizer : Randomizer<Double> {

    override fun getRandom(vararg value: Any): Double {
        TODO("Not yet implemented")
    }
}