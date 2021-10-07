package com.supper.generator.replacer

import org.springframework.stereotype.Component

@Component
class OneOfReplacer: Replacer {
    override val replaceValue: String = "@oneOf"

    override fun generate(string: String): Any? {
        val list = parseValue(string)
        return if (list.isNotEmpty()) list.random() else ""
    }
}