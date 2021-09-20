package com.supper.randomizer

import kotlin.random.Random

class NumberRandomizerImpl : NumberRandomizer {
    override fun getRandomNumber(from: Int, to: Int, negative: Boolean): Int {
        if (from < 0 && to > 0 && !negative) {
            return Random.nextInt(0, to)
        }
        return Random.nextInt()
    }

}