package com.supper.randomizer

interface DoubleRandomizer {
    fun getRandomDouble(from: Double = Double.MIN_VALUE, to: Double = Double.MAX_VALUE): Double
}