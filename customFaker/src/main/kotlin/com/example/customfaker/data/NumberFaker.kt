package com.example.customfaker.data

import kotlin.random.Random

class NumberFaker {
     fun getRandomInt(vararg value: Any): Int {
        val list = listOf(value)
        if (list.isEmpty())
            return Random.nextInt()
        return Random.nextInt(list[0] as Int,list[1] as Int)
    }
}