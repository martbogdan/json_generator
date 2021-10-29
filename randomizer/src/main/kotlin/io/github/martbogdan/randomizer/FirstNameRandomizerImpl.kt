package io.github.martbogdan.randomizer

import io.github.martbogdan.randomizer.fakedata.FirstNameFaker
import org.springframework.beans.factory.annotation.Autowired

class FirstNameRandomizerImpl(@Autowired val firstNameFaker: FirstNameFaker) : FirstNameRandomizer {

    override fun getRandomFirstName(gender: String): String {
        return firstNameFaker.getFirstName()
    }
}