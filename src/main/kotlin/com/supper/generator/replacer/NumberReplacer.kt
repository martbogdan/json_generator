package com.supper.generator.replacer

import com.supper.generator.randomizer.NumberRandomizer
import org.springframework.stereotype.Component

@Component
class NumberReplacer: Replacer {
    override val replaceValue: String = "@number"

    override fun generate(): String {
        return NumberRandomizer().getRandom().toString()
    }
}