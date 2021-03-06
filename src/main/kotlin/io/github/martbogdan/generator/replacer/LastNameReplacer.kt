package io.github.martbogdan.generator.replacer

import io.github.martbogdan.randomizer.LastNameRandomizer
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class LastNameReplacer(@Autowired val lastNameRandomizer: LastNameRandomizer) : Replacer {

    override val replaceValue: String = "@lastname"

    override fun generate(string: String): String {
        return lastNameRandomizer.getRandomLastName()
    }
}