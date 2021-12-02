package io.github.martbogdan.generator.replacer

import io.github.martbogdan.randomizer.DoubleRandomizer
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class DoubleReplacer(@Autowired val doubleRandomizer: DoubleRandomizer):
    io.github.martbogdan.generator.replacer.Replacer {
    override val replaceValue: String = "@double"

    override fun generate(string: String): Any? {
        val list = parseValue(string)
        return when (list.size) {
            3 -> String.format("%.${list[2]}f", doubleRandomizer.getRandomDouble(list[0].toDouble(), list[1].toDouble())).toDouble()
            2 -> String.format("%.3f", doubleRandomizer.getRandomDouble(list[0].toDouble(), list[1].toDouble())).toDouble()
            0 -> String.format("%.3f", doubleRandomizer.getRandomDouble()).toDouble()
            else -> "Check input parameters"
        }

    }
}