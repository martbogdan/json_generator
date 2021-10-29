package io.github.martbogdan.randomizer

import kotlin.random.Random

class NumberRandomizerImpl : NumberRandomizer {
    override fun getRandomNumber(from: Int, to: Int): Int {
        val untilMax: Int = if (to < Int.MAX_VALUE) { to+1 } else { to }
        if (from > untilMax) { //TODO think on implementation
            return Random.nextInt(untilMax, from)
        }
        return Random.nextInt(from, untilMax)
    }

}