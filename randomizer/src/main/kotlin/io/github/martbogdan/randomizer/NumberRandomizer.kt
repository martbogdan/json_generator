package io.github.martbogdan.randomizer

interface NumberRandomizer {
    fun getRandomNumber(from: Int = Int.MIN_VALUE, to: Int = Int.MAX_VALUE): Int
}