package io.github.martbogdan.generator.replacer

import org.springframework.stereotype.Component

@Component
class StringReplacer : Replacer {
    override val replaceValue: String = "@string"

    override fun generate(string: String): Any? {
        val list = parseValue(string)
        return if (list.isNotEmpty())
            getRandomString(list[0].toInt())
        else
            ""
    }

    fun getRandomString(length: Int): String {
        val allowedChars = ('A'..'Z') + ('a'..'z') + ('0'..'9')
        return (1..length)
            .map { allowedChars.random() }
            .joinToString("")
    }
}