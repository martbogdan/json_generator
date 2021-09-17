package com.supper.generator.replacer

import com.supper.generator.randomizer.FirstNameRandomizer
import io.github.serpro69.kfaker.Faker
import org.springframework.stereotype.Component

@Component
class FirstNameReplacer : Replacer {

    override val replaceValue: String = "@firstname"

    override fun generate(string: String): String {
        return FirstNameRandomizer().getRandom()
    }
}