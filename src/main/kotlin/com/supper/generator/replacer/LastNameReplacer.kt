package com.supper.generator.replacer

import io.github.serpro69.kfaker.Faker

class LastNameReplacer: Replacer() {
    override val replaceValue: String = "@lastname"

    override fun generate(): String {
        return Faker().name.lastName()
    }
}