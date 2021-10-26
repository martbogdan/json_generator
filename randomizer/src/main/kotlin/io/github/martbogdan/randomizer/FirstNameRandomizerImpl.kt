package io.github.martbogdan.randomizer

import io.github.martbogdan.customfaker.data.FirstNameFaker

class FirstNameRandomizerImpl : FirstNameRandomizer {

    override fun getRandomFirstName(gender: String): String {
        return FirstNameFaker().getFirstName()
    }
}