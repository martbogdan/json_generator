package io.github.martbogdan.randomizer

import java.time.LocalDate
import kotlin.random.Random

class DateRandomizerImpl: DateRandomizer {
    override fun getRandomDate(from: LocalDate, until: LocalDate): String {

        return randomDate(from, until).toString()
    }

    private fun randomDate(from: LocalDate, until: LocalDate): LocalDate {
        val fromEpochDay = from.toEpochDay()
        val untilEpochDay = until.toEpochDay()
        if (fromEpochDay == untilEpochDay) {
            return LocalDate.ofEpochDay(fromEpochDay)
        }
        return LocalDate.ofEpochDay(Random.nextLong(fromEpochDay, untilEpochDay))
    }

}