package io.github.martbogdan.generator.replacer

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class ListOfReplacerTest {
    private val listOfReplacer =ListOfReplacer()

    private val test1 = "@listOf(3, { fn: @fn })"
    private val test2 = "@listOf()"
    private val test3 = "@listOf"

    @Test
    fun generateTest() {
        val result1 = listOfReplacer.generate(test1)
        val result2 = listOfReplacer.generate(test2)
        val result3 = listOfReplacer.generate(test3)

        println(result1)
        println(result2)
        println(result3)
    }

    @Test
    fun parseValueTest() {
        val result1 = listOfReplacer.parseValue(test1)
        val result2 = listOfReplacer.parseValue(test2)
        val result3 = listOfReplacer.parseValue(test3)

        println(result1)
        println(result2)
        println(result3)
    }

    @Test
    fun getParamsStringTest() {
        val result1 = listOfReplacer.getParamsString(test1)
        val result2 = listOfReplacer.getParamsString(test2)
        val result3 = listOfReplacer.getParamsString(test3)

        println(result1)
        println(result2)
        println(result3)
    }
}