package com.example.customfaker.data

import com.supper.generator.randomizer.NumberRandomizer
import kotlin.random.Random

class NumberFaker: NumberRandomizer {
    override fun getRandom(vararg value: Any): Int {
        val list = listOf(value)
        if (list.isEmpty())
            return Random.nextInt()
        return Random.nextInt(list[0] as Int,list[1] as Int)
    }
}