package com.supper.randomizer

import com.supper.customfaker.data.LastNameFaker

class LastNameRandomizerImpl : LastNameRandomizer {
    override fun getRandomLastName(): String = LastNameFaker().getLastName()

}