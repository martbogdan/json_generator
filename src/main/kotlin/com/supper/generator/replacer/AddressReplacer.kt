package com.supper.generator.replacer

import io.github.serpro69.kfaker.Faker
import org.springframework.stereotype.Component

@Component
class AddressReplacer : Replacer {
    override val replaceValue: String = "@address"
    override fun canReplace(string: String): Boolean = string == replaceValue

    override fun generate(): String {
        return "Faker().address.fullAddress()"
    }
}