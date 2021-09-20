package com.supper.generator.replacer

import com.supper.randomizer.LastNameRandomizerImpl
import org.springframework.stereotype.Component

@Component
class LastNameReplacer : Replacer {

    override val replaceValue: String = "@lastname"

    override fun generate(string: String): String {
        return LastNameRandomizerImpl().getRandom(parseValue(string))
    }
}