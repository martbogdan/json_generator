package com.supper.generator

fun getRandomName(nameLength: Int = 6): String {
    val chars = ('a'..'z')
    return (1..nameLength)
        .map { chars.random() }
        .joinToString("")
}