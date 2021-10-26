package io.github.martbogdan.generator.replacer

import io.github.martbogdan.randomizer.DateRandomizer
import io.github.martbogdan.randomizer.DateRandomizerImpl
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.mockito.Mock
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.mock.mockito.MockBean
import java.time.LocalDate
import kotlin.random.Random

internal class DateReplacerTest {

    private val dateRandomizer: DateRandomizer = DateRandomizerImpl()

    @Test
    fun generate() {
    }

    @Test
    fun parseDateTest() {
        val dateString = "2021-12-21"
        val expected = LocalDate.of(2021, 12, 21)
        val actual = io.github.martbogdan.generator.replacer.DateReplacer(dateRandomizer).parseDate(dateString)
        println("expected $expected")
        println("actual $actual")
        println("${expected.month}")
        assertEquals(expected, actual)
    }

    @Test
    fun parseDateNowTest() {
        val dateString = "now"
        val expected = LocalDate.now()
        val actual = io.github.martbogdan.generator.replacer.DateReplacer(dateRandomizer).parseDate(dateString)
        println("expected $expected")
        println("actual $actual")
        println("${expected.month}")
        assertEquals(expected, actual)
    }
}