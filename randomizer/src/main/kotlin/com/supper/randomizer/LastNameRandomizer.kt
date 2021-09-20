package com.supper.randomizer

import com.example.customfaker.data.LastNameFaker

class LastNameRandomizer : Randomizer<String> {
    override fun getRandom(list: List<String>): String {
        return LastNameFaker().getLastName()
    }
}