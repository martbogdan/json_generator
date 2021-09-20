package com.supper.randomizer

interface NumberRandomizer {
    fun getRandomNumber(from: Int = Int.MIN_VALUE, to: Int = Int.MAX_VALUE, negative: Boolean = true): Int
}