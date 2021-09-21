package com.supper.generator.replacer

import com.supper.randomizer.NumberRandomizer
import com.supper.randomizer.NumberRandomizerImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class NumberReplacer(@Autowired val numberRandomizer: NumberRandomizer) : Replacer {
    override val replaceValue: String = "@number"

    override fun generate(string: String): Any? {
        val list = parseValue(string)
        if (list.size == 3) {
            return try {
                numberRandomizer.getRandomNumber(list[0].toInt(), list[1].toInt(), list[2].toBoolean())
            } catch (e: NumberFormatException) {
                string
            }
        }
        return numberRandomizer.getRandomNumber()
    }




}