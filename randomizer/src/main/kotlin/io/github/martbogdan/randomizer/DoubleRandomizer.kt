package io.github.martbogdan.randomizer

interface DoubleRandomizer {
    fun getRandomDouble(from: Double = -1000000.000, to: Double = 1000000.000): Double
}