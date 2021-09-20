package com.supper.randomizer

import com.example.customfaker.data.FirstNameFaker

class FirstNameRandomizer : Randomizer<String> {
    override fun getRandom(list: List<String>): String {
        return FirstNameFaker().getFirstName()
    }
}