package io.github.martbogdan.generator.replacer

import org.springframework.stereotype.Component

@Component
class ListOfReplacer: Replacer, OneAtReplacer() {
    override val replaceValue: String = "@listOf"
    // @listOf(3, { "fn": "@fn" }) -> [ { "fn": "AAA" }, { "fn": "BBB" },{ "fn": "CCC" } ]

    override fun generate(string: String): Any? {
        val result = mutableListOf<Any?>()
        val count = getIndexParam(getParamsString(string))
        val value = getParamValue(string)
        repeat(count) { result.add(value) }
        return result.toString()
    }

    fun getParamValue(string: String): String {
        var result: String = ""
        if (canParse(string)) {
            val str = getParamsString(string)
            val index = str.indexOfFirst { c-> c == ',' } + 1
            result = str.substring(index).trim()
        }
        return result
    }

    override fun getParamsString(string: String): String = string.drop(8).dropLast(1)
}