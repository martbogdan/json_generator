package com.supper.generator.replacer

import com.supper.randomizer.DateRandomizer
import com.supper.randomizer.DateRandomizerImpl
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.mockito.Mock
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.mock.mockito.MockBean
import java.time.LocalDate

internal class DateReplacerTest {

    private val dateRandomizer: DateRandomizer = DateRandomizerImpl()

    @Test
    fun generate() {
    }

    @Test
    fun parseDate() {
        val dateString = "2021/12/21"
        val expected = LocalDate.of(2021, 12, 21)
        val actual = DateReplacer(dateRandomizer).parseDate(dateString)
        println("expected $expected")
        println("actual $actual")
        println("${expected.month}")
        assertEquals(expected, actual)
    }
}