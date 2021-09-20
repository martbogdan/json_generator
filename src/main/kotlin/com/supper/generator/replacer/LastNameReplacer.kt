package com.supper.generator.replacer

import com.supper.randomizer.LastNameRandomizer
import org.springframework.stereotype.Component

@Component
class LastNameReplacer : Replacer {

    override val replaceValue: String = "@lastname"

    override fun generate(string: String): String {
        return LastNameRandomizer().getRandom(parseValue(string))
    }
}