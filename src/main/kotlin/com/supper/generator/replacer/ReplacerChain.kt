package com.supper.generator.replacer

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class ReplacerChain(@Autowired val replacerList: List<Replacer>) {

    fun replace(string: String): Any {
        for (item in replacerList) {
            if (item.canReplace(string))
                return item.generate(string)
        }
        return string
    }
}