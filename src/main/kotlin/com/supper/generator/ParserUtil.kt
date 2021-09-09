package com.supper.generator

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue

fun parseJsonToMap(json: String): HashMap<String, *> {
    var jsonMap = ObjectMapper().readValue<MutableMap<String, *>>(json) as HashMap<String, *>
    return processMap(jsonMap)
}

fun processMap(jMap: HashMap<String, *>): HashMap<String, *> {
    println(jMap)
    for (entry in jMap.entries) {
        when (entry.value) {
            is String -> {
                println("This is String value: ${entry.value}")
            }
            is HashMap<*, *> -> {
                println("This is Map. Start recursion")
                processMap(entry.value as HashMap<String, *>)
            }
            is List<*> -> {
                println("This is Array. Start Iterate")
                processList(entry.value as List<*>)
            }
            else -> println("SomElse")
        }
    }
    return jMap
}

fun processList(list: List<*>): List<*> {
    println(list)
    for (element in list) {
        when (element) {
            is String -> {
                println("This is String value: $element")
            }
            is HashMap<*, *> -> {
                println("This is Map. Start recursion")
                processMap(element as HashMap<String, *>)
            }
            is List<*> -> {
                println("This is Array. Start Iterate")
                processList(element)
            }
            else -> println("SomElse")
        }
    }
    return list
}

fun checkReplace(string: String): Boolean = string.startsWith('@')





