package com.supper.generator.replacer

import com.supper.randomizer.NumberRandomizer
import com.supper.randomizer.NumberRandomizerImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class NumberReplacer(@Autowired val numberRandomizer: NumberRandomizer) : Replacer {
    override val replaceValue: String = "@number"

    
    override fun generate(string: String): String {
        val list = parseValue(string)
        if (list.size == 3) {
            return numberRandomizer.getRandomNumber(list[0].toInt(), list[1].toInt(), list[2].toBoolean()).toString()
        }
        return numberRandomizer.getRandomNumber().toString()
    }




}