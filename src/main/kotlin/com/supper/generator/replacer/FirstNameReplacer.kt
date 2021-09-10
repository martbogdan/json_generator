package com.supper.generator.replacer

import io.github.serpro69.kfaker.Faker

class FirstNameReplacer: Replacer() {
    override val replaceValue: String = "@firstname"

    override fun generate(): String {
        return Faker().name.firstName()
    }
}