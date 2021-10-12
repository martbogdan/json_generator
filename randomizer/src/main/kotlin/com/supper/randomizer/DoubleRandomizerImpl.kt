package com.supper.randomizer

import kotlin.random.Random

class DoubleRandomizerImpl: DoubleRandomizer {
    override fun getRandomDouble(from: Double, to: Double): Double {
        val untilMax: Double = if (to < Double.MAX_VALUE) { to+1 } else { to }
        if (from > untilMax) { //TODO think on implementation
            return Random.nextDouble(untilMax, from)
        }
        return Random.nextDouble(from, untilMax)
    }
}