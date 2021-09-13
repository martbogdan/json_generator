package com.supper.generator.replacer

import com.supper.generator.randomizer.FirstNameRandomizer
import io.github.serpro69.kfaker.Faker
import org.springframework.stereotype.Component

@Component
class FirstNameReplacer : Replacer {

    override val replaceValue: String = "@firstname"

    override fun canReplace(string: String): Boolean = string == replaceValue

    override fun generate(): String {
        return FirstNameRandomizer().getRandom()
    }
}