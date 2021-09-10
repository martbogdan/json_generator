package com.supper.generator

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.supper.generator.replacer.*
import org.springframework.beans.factory.annotation.Autowired

class ParserUtil(@Autowired var replacerList: List<Replacer>) {

    var replacer = ReplacerChain(replacerList)


    fun parseJsonToMap(json: String): HashMap<String, Any?> {
        var jsonMap = ObjectMapper().readValue<MutableMap<String, Any?>>(json) as HashMap<String, Any?>
        return processMap(jsonMap)
    }

    fun processMap(jMap: HashMap<String, Any?>): HashMap<String, Any?> {
        println(jMap)
        for (entry in jMap.entries) {
            when (entry.value) {
                is String -> {
                    println("This is String value: ${entry.value}")
                    if (checkReplace(entry.value as String)) {
                        jMap[entry.key] = replacer.replace(entry.value as String)
                    }
                }
                is HashMap<*, *> -> {
                    println("This is Map. Start recursion")
                    processMap(entry.value as HashMap<String, Any?>)
                }
                is List<*> -> {
                    println("This is Array. Start Iterate")
                    jMap[entry.key] = processList(entry.value as List<*>)
                }
                else -> println("SomElse")
            }
        }
        return jMap
    }

    fun processList(list: List<Any?>): List<Any?> {
        val listToReturn: ArrayList<Any?> = ArrayList(list)
        println(listToReturn)
        for (element in listToReturn) {
            when (element) {
                is String -> {
                    println("This is String value: $element")
                    if (checkReplace(element)) {
                        val index = listToReturn.indexOf(element)
                        listToReturn[index] = replacer.replace(element)
                    }
                }
                is HashMap<*, *> -> {
                    println("This is Map. Start recursion")
                    processMap(element as HashMap<String, Any?>)
                }
                is List<Any?> -> {
                    println("This is Array. Start Iterate")
                    val index = listToReturn.indexOf(element)
                    listToReturn[index] = processList(element)
                }
                else -> println("SomElse")
            }
        }
        return listToReturn
    }

    fun checkReplace(string: String): Boolean = string.startsWith('@')


}


