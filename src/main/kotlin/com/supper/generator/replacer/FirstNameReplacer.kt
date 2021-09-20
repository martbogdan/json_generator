package com.supper.generator.replacer


import com.supper.randomizer.FirstNameRandomizer
import org.springframework.stereotype.Component

@Component
class FirstNameReplacer : Replacer {

    override val replaceValue: String = "@firstname"

    override fun generate(string: String): String {

        return FirstNameRandomizer().getRandom(parseValue(string))
    }
}