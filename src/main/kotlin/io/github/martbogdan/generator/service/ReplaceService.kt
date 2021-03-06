package io.github.martbogdan.generator.service

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import io.github.martbogdan.generator.replacer.*
import io.github.martbogdan.generator.service.GenerateService.Companion.COUNT_KEY
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ReplaceService(@Autowired val replacer: ReplacerChain) {

    fun parseJsonToMap(json: String): HashMap<String, Any?> {
        return ObjectMapper().readValue<MutableMap<String, Any?>>(json) as HashMap<String, Any?>
    }

    fun processReplace(json: String): HashMap<String, Any?> {
        val jsonMap = parseJsonToMap(json)
        jsonMap.remove(COUNT_KEY)

        val result = ReferenceService(this).preProcessMap(jsonMap)

        return processMap(result)
    }

    fun processMap(jMap: HashMap<String, Any?>): HashMap<String, Any?> {
        for (entry in jMap.entries) {
            when (entry.value) {
                is String -> {
                    if (checkReplace(entry.value as String)) {
                        jMap[entry.key] = replacer.replace(entry.value as String)
                    }
                }
                is HashMap<*, *> -> {
                    val map = entry.value as HashMap<String, Any?>
                    var count = 1
                    if (map.containsKey(COUNT_KEY)) {
                        count = map[COUNT_KEY].toString().toInt()
                        map.remove(COUNT_KEY)
                    }
                    if (count > 1) {
                        val list = mutableListOf<Any?>()

                        val mapS = ObjectMapper().writeValueAsString(map)
                        repeat(count) {
                            list.add(processReplace(mapS))
                        }
                        jMap[entry.key] = list
                    } else {
                        processMap(entry.value as HashMap<String, Any?>)
                    }
                }
                is List<*> -> jMap[entry.key] = processList(entry.value as List<*>)
            }
        }
        return jMap
    }

    private fun processList(list: List<Any?>): List<Any?> {
        val result: ArrayList<Any?> = ArrayList(list)
        for (element in result) {
            when (element) {
                is String -> {
                    if (checkReplace(element)) {
                        val index = result.indexOf(element)
                        result[index] = replacer.replace(element)
                    }
                }
                is HashMap<*, *> -> processMap(element as HashMap<String, Any?>)
                is List<Any?> -> {
                    val index = result.indexOf(element)
                    result[index] = processList(element)
                }
            }
        }
        return result
    }

    fun checkReplace(string: String): Boolean = string.startsWith('@')


}


