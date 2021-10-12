package com.supper.generator.replacer

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class ManyOfReplacerTest {

    @Test
    fun generate() {
        val str1 = "@manyOf(2, [[v1, v2], [v3, v4], [v5, v6]])"
        val str2 = "@manyOf(3, [v1, v2, v3, v4, v5, v6])"
        val str3 = "@manyOf(4, v1, v2, v3, v4, v5, v6)"
        val str4 = "@manyOf(4, [])"
        val str5 = "@manyOf(3, [{v1, v2}, {v3, v4}, {v5, v6}])"
        val str6 = "@manyOf(3, [[{v1, v2}, {v3, v4}], [{v5, v6}]])"
        val manyOfReplacer = ManyOfReplacer()
        val result1 = manyOfReplacer.generate(str1)
        val result2 = manyOfReplacer.generate(str2)
        val result3 = manyOfReplacer.generate(str3)
        val result4 = manyOfReplacer.generate(str4)
        val result5 = manyOfReplacer.generate(str5)
        val result6 = manyOfReplacer.generate(str6)
        println(result1)
        println(result2)
        println(result3)
        println(result4)
        println(result5)
        println(result6)
    }
}