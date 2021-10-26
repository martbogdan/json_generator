package io.github.martbogdan.randomizer

interface FirstNameRandomizer {
    fun getRandomFirstName(gender: String = "any") : String
}