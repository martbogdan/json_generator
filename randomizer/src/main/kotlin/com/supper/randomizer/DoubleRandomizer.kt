package com.supper.randomizer

import kotlin.random.Random

interface DoubleRandomizer : Randomizer<Double> {

    override fun getRandom(list: List<String>): Double {
        TODO("Not yet implemented")
    }
}