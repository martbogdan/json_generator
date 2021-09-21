package com.supper.randomizer

import kotlin.random.Random

class NumberRandomizerImpl : NumberRandomizer {
    override fun getRandomNumber(from: Int, until: Int, negative: Boolean): Int {
        if (from < 0 && until > 0 && !negative) {
            return Random.nextInt(0, until)
        }
        return Random.nextInt()
    }

}