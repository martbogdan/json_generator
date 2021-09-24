package com.supper.generator.service

import com.supper.generator.replacer.ReplacerChain
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ReferenceService(@Autowired val replaceService: ReplaceService) {

    private fun hasReferences(json: String): Boolean = json.contains('#')

    fun getReferences(json: String): List<String> {
        val result = mutableListOf<String>()
        for (index in json.indices) {
            if (json[index] == '#') {
                val ind = json.substring(index).indexOfFirst { c -> c == ',' }
                result.add(json.substring(index+1, index + ind))
            }
        }
        return result
    }


    private fun processMapG(jMap: HashMap<String, Any?>, function: (input: Any?) -> Unit): HashMap<String, Any?> {
        for (entry in jMap.entries) {
            when (entry.value) {
                is String -> function(entry.value)
                is HashMap<*, *> -> processMapG(entry.value as HashMap<String, Any?>, function)
                is List<*> -> {jMap[entry.key] = processListG(entry.value as List<*>, function)}
                else -> println("SomElse")
            }
        }
        return jMap
    }

    private fun processListG(list: List<Any?>, function: (input: Any?) -> Unit): List<Any?> {
        val listToReturn: ArrayList<Any?> = ArrayList(list)
        for (element in listToReturn) {
            when (element) {
                is String -> function(element)
                is HashMap<*, *> -> processMapG(element as HashMap<String, Any?>, function)
                is List<Any?> -> {
                    val index = listToReturn.indexOf(element)
                    listToReturn[index] = processListG(element, function)
                }
                else -> println("SomElse")
            }
        }
        return listToReturn
    }


    fun getReferencesMap(json: String): List<String> {
        val result = mutableListOf<String>()
        val map = replaceService.parseJsonToMap(json)
        for (entry in map.entries) {
            when (entry.value) {
                is String -> {
                    if ((entry.value as String).startsWith('#'))
                        result.add(entry.value as String)
                }
            }
        }
        return result
    }

    fun initRefValues(refList: List<String>, jMap: HashMap<String, Any?>): HashMap<String, Any?> {
        val map = hashMapOf<String, Any?>()
        for (ref in refList) {
            for (entry in jMap.entries) {
                if (entry.value is HashMap<*,*>) {
                    initRefValues(refList, entry.value as HashMap<String, Any?>)
                }
                if (ref == entry.key && replaceService.checkReplace(entry.value as String)) {
                    map[ref] = entry.value
                }
            }
        }
        return map
    }
}