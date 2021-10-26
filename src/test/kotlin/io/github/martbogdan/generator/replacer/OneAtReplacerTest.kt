package io.github.martbogdan.generator.replacer

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class OneAtReplacerTest {

    @Test
    fun generateTest() {
        val str1 = "@oneAt(2, [[v1, v2], [v3, v4], [v5, v6]])"
        val str2 = "@oneAt(2, [v1, v2, v3, v4, v5, v6])"
        val str3 = "@oneAt(4, v1, v2, v3, v4, v5, v6)"
        val str4 = "@oneAt(0, [{v1, v2}, {v3, v4}, {v5, v6}])"
        val str5 = "@oneAt(0, [[{v1, v2}, {v3, v4}], [{v5, v6}]])"
        val oneAtReplacer = OneAtReplacer()
        val result1 = oneAtReplacer.generate(str1)
        val result2 = oneAtReplacer.generate(str2)
        val result3 = oneAtReplacer.generate(str3)
        val result4 = oneAtReplacer.generate(str4)
        val result5 = oneAtReplacer.generate(str5)
        println(result1)
        println(result2)
        println(result3)
        println(result4)
        println(result5)
        assertEquals("[v5, v6]", result1)
        assertEquals("v3", result2)
        assertEquals("v5", result3)
    }

    @Test
    fun getParamsString() {
    }

    @Test
    fun getIndexParam() {
    }

    @Test
    fun getArrayParam() {
        val oneAtReplacer = OneAtReplacer()
        val str = "1, [[v1, v2], [v3, v4], [v5, v6]]"
        val expected = "[v1, v2], [v3, v4], [v5, v6]"
        val result = oneAtReplacer.getArrayParam(str)
        println(result)
        assertEquals(expected, result)

    }

    @Test
    fun getInnerArrays() {
    }
}