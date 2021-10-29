package io.github.martbogdan.randomizer

import io.github.martbogdan.randomizer.fakedata.LastNameFaker
import org.springframework.beans.factory.annotation.Autowired

class LastNameRandomizerImpl(@Autowired val lastNameFaker: LastNameFaker) : LastNameRandomizer {
    override fun getRandomLastName(): String = lastNameFaker.getLastName()

}