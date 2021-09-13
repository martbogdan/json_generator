package com.supper.generator.randomizer

import kotlin.random.Random

class NumberRandomizer(private val min: Int = Int.MIN_VALUE, private val max: Int = Int.MAX_VALUE) : Randomizer<Int> {

    override fun getRandom(): Int {
        return Random.nextInt(min, max)
    }
}