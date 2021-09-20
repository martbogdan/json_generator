package com.supper.generator.replacer

import com.supper.randomizer.NumberRandomizer
import org.springframework.stereotype.Component

@Component
class NumberReplacer : Replacer {
    override val replaceValue: String = "@number"

    
    override fun generate(string: String): String {
        val list = parseValue(string)
        return NumberRandomizer().getRandom(list).toString()
    }




}