package com.supper.generator.replacer


import com.supper.randomizer.FirstNameRandomizerImpl
import org.springframework.stereotype.Component

@Component
class FirstNameReplacer : Replacer {

    override val replaceValue: String = "@firstname"

    override fun generate(string: String): String {

        return FirstNameRandomizerImpl().getRandom(parseValue(string))
    }
}