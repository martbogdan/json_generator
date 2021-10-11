package com.supper.generator.replacer

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class OneOfReplacerTest {

    @Test
    fun getArrayValues() {
        val v1 = "@oneOf(1,2,3,4)"
        val v2 = "@oneOf([1,2,3,4])"
        val v3 = "@oneOf([[1,2],[3,4]])"
        val oneOfReplacer = OneOfReplacer()
        println(oneOfReplacer.getArrayValues(v1))
        println(oneOfReplacer.getArrayValues(v2))
        println(oneOfReplacer.getArrayValues(v3))
    }

    @Test
    fun getInnerArraysTest() {
        var v3 = "[1,2],[3,4]"
        val oneOfReplacer = OneOfReplacer()

        println(oneOfReplacer.getInnerArrays(v3))
    }
}