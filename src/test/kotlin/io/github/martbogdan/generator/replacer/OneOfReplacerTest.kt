package io.github.martbogdan.generator.replacer

import org.junit.jupiter.api.Test

internal class OneOfReplacerTest {

    @Test
    fun getArrayValues() {
        val v1 = "@oneOf(1,2,3,4)"
        val v2 = "@oneOf([1,2,3,4])"
        val v3 = "@oneOf([[1,2],[3,4]])"
        val oneOfReplacer = OneOfReplacer()

        val res1 = oneOfReplacer.getArrayValues(v1)
        val res2 = oneOfReplacer.getArrayValues(v2)
        val res3 = oneOfReplacer.getArrayValues(v3)
        println(res1)
        println(res2)
        println(res3)
        assert("1,2,3,4" == res1)
        assert("1,2,3,4" == res2)
        assert("[1,2],[3,4]" == res3)
    }

    @Test
    fun getInnerArraysTest() {
        val v1 = "[1,2],[3,4]"
        val v2 = "{1,2},{3,4}"
        val oneOfReplacer = OneOfReplacer()

        val res1 = oneOfReplacer.getInnerArrays(v1)
        val res2 = oneOfReplacer.getInnerArrays(v2)
        println(res1)
        println(res2)

        assert(listOf("[1,2]","[3,4]") == res1)
        assert(listOf("{1,2}","{3,4}") == res2)
    }
}