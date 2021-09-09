package com.supper.generator

import io.github.serpro69.kfaker.Faker

class Replacer() {

    fun replaceValue(value: String): String {
        var fakeVAlue: String = value
        when (value) {
            "@firstname" -> fakeVAlue = getFakeFirstName()
            "@lastname" -> fakeVAlue = getFakeLastName()
            "@address" -> fakeVAlue = getFakeAddress()
        }

        return fakeVAlue
    }

    private fun getFakeFirstName(): String {
        return Faker().name.firstName()
    }

    private fun getFakeLastName(): String {
        return Faker().name.lastName()
    }

    private fun getFakeAddress(): String {
        return Faker().address.fullAddress()
    }
}