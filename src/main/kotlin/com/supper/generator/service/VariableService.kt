package com.supper.generator.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class VariableService(@Autowired val replaceService: ReplaceService) {

    val variable: String = "@var"

    fun getVariables(string: String): Map<String, Any?> {
        val jsonMap = replaceService.parseJsonToMap(string)
        return jsonMap.filter { entry -> entry.key.startsWith(variable) }
    }
}