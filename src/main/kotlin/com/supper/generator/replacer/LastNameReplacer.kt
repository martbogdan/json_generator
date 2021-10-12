package com.supper.generator.replacer

import com.supper.randomizer.LastNameRandomizer
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class LastNameReplacer(@Autowired val lastNameRandomizer: LastNameRandomizer) : Replacer {

    override val replaceValue: String = "@lastname"

    override fun generate(string: String): String {
        return lastNameRandomizer.getRandomLastName()
    }
}