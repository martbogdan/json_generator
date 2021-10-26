package io.github.martbogdan.generator.replacer


import io.github.martbogdan.randomizer.FirstNameRandomizer
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class FirstNameReplacer(@Autowired val firstNameRandomizer: FirstNameRandomizer) : Replacer {

    override val replaceValue: String = "@firstname"

    override fun generate(string: String): String {

        return firstNameRandomizer.getRandomFirstName()
    }
}