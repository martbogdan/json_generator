package com.supper.generator.replacer

import com.supper.randomizer.NumberRandomizerImpl
import org.springframework.stereotype.Component

@Component
class NumberReplacer : Replacer {
    override val replaceValue: String = "@number"

    
    override fun generate(string: String): String {
        val list = parseValue(string)
        return NumberRandomizerImpl().getRandom(list).toString()
    }




}