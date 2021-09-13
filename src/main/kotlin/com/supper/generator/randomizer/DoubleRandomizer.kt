package com.supper.generator.randomizer

import kotlin.random.Random

class DoubleRandomizer(private val min: Double = Double.MIN_VALUE, private val max: Double = Double.MAX_VALUE) :
    Randomizer<Double> {
    override fun getRandom(): Double {
        return Random.nextDouble(min, max)
    }
}