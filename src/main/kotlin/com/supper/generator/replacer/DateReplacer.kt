package com.supper.generator.replacer

import com.supper.randomizer.DateRandomizer
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@Component
class DateReplacer(@Autowired val dateRandomizer: DateRandomizer): Replacer {
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
        return dateRandomizer.getRandomDate()
    }

    fun parseDate(string: String): LocalDate {
        val formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd")
        return LocalDate.parse(string, formatter)
    }

    fun checkValue(value: String): String {
        when (value) {
            "#dateOfBirth" -> {return parseDate(value).toString()}
            "now" -> {return LocalDate.now().toString()}
        }
        return value
    }
}