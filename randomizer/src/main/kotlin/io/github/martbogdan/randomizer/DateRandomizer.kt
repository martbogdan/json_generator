package io.github.martbogdan.randomizer

import java.time.LocalDate

interface DateRandomizer {
    fun getRandomDate(
        from: LocalDate = LocalDate.of(1900, 1, 1),
        until: LocalDate = LocalDate.now()
    ): String
}