package com.supper.randomizer

import kotlin.random.Random

class NumberRandomizerImpl : NumberRandomizer {
    override fun getRandomNumber(from: Int, until: Int): Int {
        val untilMax: Int = if (until < Int.MAX_VALUE) { until+1 } else { until }
        if (from > untilMax) { //TODO think on implementation
            return Random.nextInt(untilMax, from)
        }
        return Random.nextInt(from, untilMax)
    }

}