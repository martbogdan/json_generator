package com.supper.generator.parser

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class NumberParserTest {

    @Test
    fun parseValue() {
        val string = "@number(1, 10, false)"
        val list = listOf<Any>(1, 10, false)

//        val listParse = NumberParser().parseValue(string)
//        println(listParse)
//        assertEquals(list, listParse)
    }
}