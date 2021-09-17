package com.supper.generator.replacer

interface Replacer {
    val replaceValue: String

    fun generate(string: String): Any


    fun canReplace(string: String): Boolean = string.contains(replaceValue)

    fun parseValue(string: String): List<Any> {
        if (canParse(string)) {
            return string
                .substring(string.indexOf('(')+1, string.indexOf(')'))
                .split(',')
        }
        return emptyList()
    }

    fun canParse(string: String): Boolean {
        return string.contains('(') && string.endsWith(')')
    }
}