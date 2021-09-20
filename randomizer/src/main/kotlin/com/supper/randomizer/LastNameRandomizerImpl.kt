package com.supper.randomizer

import com.example.customfaker.data.LastNameFaker

class LastNameRandomizerImpl : LastNameRandomizer {
    override fun getRandomLastName(): String = LastNameFaker().getLastName()

}