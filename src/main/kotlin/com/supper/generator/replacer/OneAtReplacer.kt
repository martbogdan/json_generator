package com.supper.generator.replacer

import org.springframework.stereotype.Component

@Component
class OneAtReplacer: Replacer {
    override val replaceValue: String = "@oneAt"

    override fun generate(string: String): Any? {
        val index = getIndexParam(getParamsString(string))
        return parseValue(string)[index]
    }

    override fun parseValue(string: String): List<String> {
        if (canParse(string)) {
            var str = getParamsString(string)
            str = getArrayParam(str)
            var list = if (str.contains('[') || str.contains('{')) getInnerArrays(str) else str.split(',')
            return list.map { e -> e.trim() }
        }
        return emptyList()
    }

    fun getParamsString(string: String): String = string.drop(7).dropLast(1)

    fun getIndexParam(string: String): Int = string.split(',')[0].toInt()

    fun getArrayParam(string: String): String {
        var result = string.substring(string.indexOfFirst { c -> c == ',' } + 1).trim()
        if (result.startsWith('[') && result.endsWith(']')) {
            result = result.drop(1).dropLast(1)
        }
        return result
    }


    fun getInnerArrays(string: String): List<String> {
        val list = mutableListOf<String>()
        var start = -1
        var end = -1
        val brackets = checkBrackets(string)
        for (index in string.indices) {
            if (string[index] == brackets[0]) {
                start = index
            }
            if (string[index] == brackets[1]) {
                end = index
            }
            if (start in 0 until end) {
                list.add(string.substring(start, end + 1))
                start = end
            }
        }
        return list
    }

    fun checkBrackets(string: String): List<Char> {
        if (string.contains('[')) {
            return listOf('[', ']')
        } else if (string.contains('{') && !string.contains('[')) {
            return listOf('{', '}')
        }
        return listOf()
    }

}