package com.supper.generator.service

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.supper.generator.replacer.*
import com.supper.generator.service.GenerateService.Companion.COUNT
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ReplaceService(@Autowired val replacer: ReplacerChain) {

    fun parseJsonToMap(json: String): HashMap<String, Any?> {
        return ObjectMapper().readValue<MutableMap<String, Any?>>(json) as HashMap<String, Any?>
    }

    fun processReplace(json: String): HashMap<String, Any?> {
        val jsonMap = parseJsonToMap(json)
        jsonMap.remove(COUNT)

        // 1 replace var TODO

        // 2 replace ref
        var result = ReferenceService(this).preProcessMap(jsonMap)

        return processMap(result)
    }

    fun processMap(jMap: HashMap<String, Any?>): HashMap<String, Any?> {
        val start = System.currentTimeMillis()
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
        val end = System.currentTimeMillis()
        println("Time to process Map ${end - start}")
        return jMap
    }

    private fun processList(list: List<Any?>): List<Any?> {
        val result: ArrayList<Any?> = ArrayList(list)
        println(result)
        for (element in result) {
            when (element) {
                is String -> {
                    println("This is String value: $element")
                    if (checkReplace(element)) {
                        val index = result.indexOf(element)
                        result[index] = replacer.replace(element)
                    }
                }
                is HashMap<*, *> -> {
                    println("This is Map. Start recursion")
                    processMap(element as HashMap<String, Any?>)
                }
                is List<Any?> -> {
                    println("This is Array. Start Iterate")
                    val index = result.indexOf(element)
                    result[index] = processList(element)
                }
                else -> println("SomElse")
            }
        }
        return result
    }

    fun checkReplace(string: String): Boolean = string.startsWith('@')


}


