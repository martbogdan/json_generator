package io.github.martbogdan.generator.replacer

import io.github.martbogdan.randomizer.NumberRandomizer
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class NumberReplacer(@Autowired val numberRandomizer: NumberRandomizer) : Replacer {
    override val replaceValue: String = "@number"

    override fun generate(string: String): Any? {
        val list = parseValue(string)
        return when (list.size) {
            2 -> numberRandomizer.getRandomNumber(list[0].toInt(), list[1].toInt())
            0 -> numberRandomizer.getRandomNumber()
            else -> "Check input parameters"
        }
    }




}