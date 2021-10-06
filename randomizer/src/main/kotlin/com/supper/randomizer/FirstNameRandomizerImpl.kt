package com.supper.randomizer

import com.supper.customfaker.data.FirstNameFaker

class FirstNameRandomizerImpl : FirstNameRandomizer {

    override fun getRandomFirstName(gender: String): String {
        return FirstNameFaker().getFirstName()
    }
}