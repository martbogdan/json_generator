package com.supper.generator.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class VariableService(@Autowired val replaceService: ReplaceService) {

    val variable: String = "@var"
//    val referenceService = ReferenceService(replaceService)

    fun getVariablesMap(string: String): Map<String, Any?> {
        val jsonMap = replaceService.parseJsonToMap(string)
        return jsonMap[variable] as HashMap<String, Any?>
    }

//    fun processVarMap(string: String) {
//        val refSet = referenceService.getReferences(string)
//        val valMap = getVariablesMap(string)
//    }
}