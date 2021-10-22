package com.supper.generator.replacer

interface Replacer {
    val replaceValue: String

    fun generate(string: String): Any?


    fun canReplace(string: String): Boolean = string.startsWith(replaceValue)

    fun parseValue(string: String): List<String> {
        if (canParse(string)) {
            var list = string
                .substring(string.indexOf('(')+1, string.indexOf(')'))
                .split(',')
            return list.map { e -> e.trim() }
        }
        return emptyList()
    }

    fun canParse(string: String): Boolean {
        return string.contains('(') && string.endsWith(')')
    }
}