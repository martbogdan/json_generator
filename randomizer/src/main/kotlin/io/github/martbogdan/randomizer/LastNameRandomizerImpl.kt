package io.github.martbogdan.randomizer

import io.github.martbogdan.randomizer.fakedata.LastNameFaker

class LastNameRandomizerImpl : LastNameRandomizer {
    override fun getRandomLastName(): String = LastNameFaker().getLastName()

}