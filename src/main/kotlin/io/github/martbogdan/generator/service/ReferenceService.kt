package io.github.martbogdan.generator.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ReferenceService(@Autowired val replaceService: ReplaceService) {

    companion object {
        private const val VAR_KEY = "@var"
    }
    private val endOfReferenceSet = setOf(',', '"', ']', ')', '}')
    private fun hasReferences(json: String): Boolean = json.contains('#')

    fun getReferences(json: String): Set<String> {
        val result = mutableSetOf<String>()
        for (index in json.indices) {
            if (json[index] == '#') {
                val ind = json.substring(index).indexOfFirst { c -> endOfReferenceSet.contains(c) }
                val end = if (ind < 0) json.lastIndex + 1 else index + ind
                result.add(json.substring(index + 1, end))
            }
        }
        return result
    }

    fun preProcessMap(jMap: HashMap<String, Any?>): HashMap<String, Any?> {
        val refMap = initRefValues(getReferences(jMap.toString()), jMap)
        for (entry in refMap.entries) {
            if (jMap.containsKey(entry.key)) {
                jMap[entry.key] = entry.value
            }
        }

        replaceReferenceMap(refMap, jMap)
        jMap.remove(VAR_KEY)
        return jMap
    }

    fun initRefValues(refSet: Set<String>, jMap: HashMap<String, Any?>): HashMap<String, Any?> {
        val refMap = HashMap<String, Any?>()
        for (ref in refSet) {
            refMap[ref] = jMap[ref]
        }
        if (jMap.containsKey(VAR_KEY)) {
            val varMap = jMap[VAR_KEY] as HashMap<String, Any?>
            for (entry in varMap.entries) {
                refMap[entry.key] = entry.value
            }
        }
        return replaceReferenceValues(refMap)
    }

    private fun replaceReferenceValues(refMap: HashMap<String, Any?>): HashMap<String, Any?> {
        if (refMap.toString().contains('#')) {
            while (refMap.toString().contains('#')) {
                for (entry in refMap.entries) {
                    if (replaceService.checkReplace(entry.value.toString()) && !hasReferences(entry.value.toString())) {
                        refMap[entry.key] = replaceService.replacer.replace(entry.value.toString())
                    }
                    if (hasReferences(entry.value.toString())) {
                        for (item in getReferences(entry.value.toString())) {
                            if (!replaceService.checkReplace(refMap[item].toString())) {
                                refMap[entry.key] = entry.value.toString().replace("#$item", refMap[item].toString())
                            }
                        }
                    }
                }
            }
        }
        replaceService.processMap(refMap)
        return refMap
    }

    private fun replaceReferenceMap(refMap: HashMap<String, Any?>, jMap: HashMap<String, Any?>) {
        for (entry in jMap.entries) {
            when (entry.value) {
                is String -> {
                    if (hasReferences(entry.value.toString())) {
                        for (item in getReferences(entry.value.toString())) {
                            jMap[entry.key] = entry.value.toString().replace("#$item", refMap[item].toString())
                        }
                    }
                }
                is HashMap<*, *> -> replaceReferenceMap(refMap, entry.value as HashMap<String, Any?>)
                is List<*> -> jMap[entry.key] = replaceReferenceList(refMap, entry.value as List<Any?>)
            }
        }
    }

    private fun replaceReferenceList(refMap: HashMap<String, Any?>, list: List<Any?>): List<Any?> {
        val result: ArrayList<Any?> = ArrayList(list)
        for (element in result) {
            when (element) {
                is String -> {
                    if (element.startsWith('#')) {
                        val index = result.indexOf(element)
                        result[index] = refMap[element.substring(1)]
                    }
                }
                is HashMap<*, *> -> replaceReferenceMap(refMap, element as HashMap<String, Any?>)
                is List<Any?> -> {
                    val index = result.indexOf(element)
                    result[index] = replaceReferenceList(refMap, element)
                }
            }
        }
        return result
    }
}