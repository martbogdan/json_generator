package com.supper.generator.replacer

import com.supper.generator.randomizer.LastNameRandomizer
import io.github.serpro69.kfaker.Faker
import org.springframework.stereotype.Component

@Component
class LastNameReplacer : Replacer {

    override val replaceValue: String = "@lastname"

    override fun generate(string: String): String {
        return LastNameRandomizer().getRandom()
    }
}