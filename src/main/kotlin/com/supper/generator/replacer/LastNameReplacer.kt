package com.supper.generator.replacer

import com.supper.generator.randomizer.LastNameRandomizer
import io.github.serpro69.kfaker.Faker
import org.springframework.stereotype.Component

@Component
class LastNameReplacer : Replacer {

    override val replaceValue: String = "@lastname"
    override fun canReplace(string: String): Boolean = string == replaceValue

    override fun generate(): String {
        return LastNameRandomizer().getRandom()
    }
}