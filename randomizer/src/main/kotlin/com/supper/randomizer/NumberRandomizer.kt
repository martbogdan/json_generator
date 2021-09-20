package com.supper.randomizer

import kotlin.random.Random

class NumberRandomizer : Randomizer<Int> {
    override fun getRandom(list: List<String>): Int {
        println("value is $list")
        if (list.isEmpty()) {
            return Random.nextInt()
        }
        return Random.nextInt(list[0].toInt(), list[1].toInt())

    }
}