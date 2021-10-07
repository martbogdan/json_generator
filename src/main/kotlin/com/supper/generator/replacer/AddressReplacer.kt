package com.supper.generator.replacer

import org.springframework.stereotype.Component

@Component
class AddressReplacer : Replacer {
    override val replaceValue: String = "@address"

    override fun generate(string: String): String {
        return "Faker().address.fullAddress()"
    }
}