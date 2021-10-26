package io.github.martbogdan.customfaker.data

import kotlin.random.Random

class NumberFaker {
     fun getRandomInt(vararg value: Any): Int {
        val list = listOf(value)
        if (list.isEmpty())
            return Random.nextInt()
        return Random.nextInt(list[0].toString().toInt(), list[1].toString().toInt())
    }
}