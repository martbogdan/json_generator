package io.github.martbogdan.generator.replacer

import io.github.martbogdan.randomizer.DoubleRandomizerImpl
import org.junit.jupiter.api.Test


internal class DoubleReplacerTest {

    private val doubleRandomizer = DoubleRandomizerImpl()
    private val doubleReplacer = DoubleReplacer(doubleRandomizer)

    @Test
    fun generateNoParam() {
        val replacer = "@double"
        val result = doubleReplacer.generate(replacer)
        println(result)
        assert(result is Double)
    }

    @Test
    fun generateTwoParams() {
        val replacer = "@double(-125.6, -256.9)"
        val result = doubleReplacer.generate(replacer)
        println(result)
        assert(result is Double)
    }

    @Test
    fun generateThreeParams() {
        val replacer = "@double(-10.0, 20.0, 1)"
        val result = doubleReplacer.generate(replacer)
        println(result)
        assert(result is Double)
    }
}