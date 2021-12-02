package io.github.martbogdan.generator.replacer

import io.github.martbogdan.randomizer.DateRandomizer
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*

@Component
class DateReplacer(@Autowired val dateRandomizer: DateRandomizer): io.github.martbogdan.generator.replacer.Replacer {
    override val replaceValue: String = "@date"

    override fun generate(string: String): Any? {
        val list = parseValue(string)
        if (list.size == 2) {
            val dateFrom = parseDate(list[0])
            val dateUntil = parseDate(list[1])
            return try {
                dateRandomizer.getRandomDate(dateFrom, dateUntil)
            } catch (e: IllegalArgumentException) {
                string
            }
        }
        if (list.size == 1 && list[0] == "long") {
            return Date().time
        }
        return dateRandomizer.getRandomDate()
    }

    fun parseDate(string: String): LocalDate {
        if ("now" == string) {
            return LocalDate.now()
        }
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
        return LocalDate.parse(string, formatter)
    }

}