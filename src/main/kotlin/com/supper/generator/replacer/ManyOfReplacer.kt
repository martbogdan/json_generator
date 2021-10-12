package com.supper.generator.replacer

import org.springframework.stereotype.Component
import kotlin.random.Random

@Component
class ManyOfReplacer : Replacer, OneAtReplacer() {
    override val replaceValue: String = "@manyOf"

    override fun generate(string: String): Any? {
        val result = mutableListOf<Any?>()
        var count = getIndexParam(getParamsString(string))
        val list = parseValue(string)
        if (list.isNotEmpty()) {
            count = if (count > list.lastIndex) list.lastIndex else count
            val random = Random.nextInt(0, count + 1)
            repeat(random) { result.add(list.random()) }
        }
        return result
    }

    override fun getParamsString(string: String): String = string.drop(8).dropLast(1)
}