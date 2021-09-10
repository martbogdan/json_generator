package com.supper.generator.replacer

interface Replacer {
    val replaceValue: String

    fun canReplace(string: String): Boolean
    fun generate(): String
}