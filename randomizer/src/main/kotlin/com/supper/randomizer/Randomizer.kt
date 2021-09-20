package com.supper.randomizer

interface Randomizer<T> {
    fun getRandom(list: List<String>): T
}