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
        return when (list.size) {
            2 -> {numberRandomizer.getRandomNumber(list[0].toInt(), list[1].toInt())
//                try {
//                    numberRandomizer.getRandomNumber(list[0].toInt(), list[1].toInt())
//                } catch (e: NumberFormatException) {
////                    e.message
//                } catch (ex: IllegalArgumentException) {
////                    ex.message
//                }
            }
            0 -> numberRandomizer.getRandomNumber()
            else -> "Check input parameters"
        }
    }




}