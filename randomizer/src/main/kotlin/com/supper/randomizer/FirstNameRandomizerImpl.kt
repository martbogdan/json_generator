package com.supper.randomizer

import com.example.customfaker.data.FirstNameFaker

class FirstNameRandomizerImpl : FirstNameRandomizer {

    override fun getRandomFirstName(gender: String): String {
        return FirstNameFaker().getFirstName()
    }
}