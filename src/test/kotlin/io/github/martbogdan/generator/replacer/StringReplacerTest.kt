package io.github.martbogdan.generator.replacer

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class StringReplacerTest {

    private val strReplacer = StringReplacer()

    @Test
    fun generate() {
        val replacer = "@string(40)"
        val result = strReplacer.generate(replacer)
        println(result)
        assertEquals(40, (result as String).length)
    }

    @Test
    fun getRandomString() {
        val length = 40
        val result = strReplacer.getRandomString(length)
        println(result)
        assertEquals(length, result.length)
    }
}