package io.github.martbogdan.generator.replacer

import org.springframework.stereotype.Component

@Component
class OneOfReplacer: Replacer, OneAtReplacer() {
    override val replaceValue: String = "@oneOf"

    override fun generate(string: String): Any? {
        val list = parseValue(string)
        return if (list.isNotEmpty()) list.random() else ""
    }

    override fun parseValue(string: String): List<String> {
        if (canParse(string)) {
            val str = getArrayValues(string)
            var list = if (str.contains('[')) getInnerArrays(str) else str.split(',')
            return list.map { e -> e.trim() }
        }
        return emptyList()
    }

    fun getArrayValues(string: String): String {
        var result = string.drop(7).dropLast(1)
        if (result.startsWith('[') && result.endsWith(']')) {
            result = result.drop(1).dropLast(1)
        }
        return result
    }

}