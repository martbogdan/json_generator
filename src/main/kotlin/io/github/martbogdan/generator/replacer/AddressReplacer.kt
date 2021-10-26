package io.github.martbogdan.generator.replacer

import org.springframework.stereotype.Component

@Component
class AddressReplacer : io.github.martbogdan.generator.replacer.Replacer {
    override val replaceValue: String = "@address"

    override fun generate(string: String): String {
        return "Faker().address.fullAddress()"
    }
}