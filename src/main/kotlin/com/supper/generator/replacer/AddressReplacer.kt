package com.supper.generator.replacer

import io.github.serpro69.kfaker.Faker

class AddressReplacer: Replacer() {
    override val replaceValue: String = "@address"

    override fun generate(): String {
        return Faker().address.fullAddress()
    }
}