package io.github.martbogdan.randomizer

import io.github.martbogdan.customfaker.data.LastNameFaker

class LastNameRandomizerImpl : LastNameRandomizer {
    override fun getRandomLastName(): String = LastNameFaker().getLastName()

}