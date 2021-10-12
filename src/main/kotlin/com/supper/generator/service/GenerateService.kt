package com.supper.generator.service

import com.fasterxml.jackson.databind.util.JSONPObject
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class GenerateService(@Autowired val replaceService: ReplaceService) {

    companion object {
        const val COUNT = "@count"
    }

    val logger: Logger = LoggerFactory.getLogger(javaClass)

    fun generateJsonList(jsonTemplate: String, count: Int?): List<Any> {
        val start = System.currentTimeMillis()

        val countTimes = getCount(jsonTemplate, count)
        logger.info("Started generating $countTimes objects...")
        val jsonList = mutableListOf<Any>()
        repeat(countTimes) {
            jsonList.add(replaceService.processReplace(jsonTemplate))
        }

        val end = System.currentTimeMillis()
        logger.info("Time for $countTimes objects is ${end - start} ms")
        return jsonList
    }

    fun getCount(json: String, count: Int?): Int {
        val jsonMap = replaceService.parseJsonToMap(json)
        return if (count != null && count > 0) {
            count
        } else if (jsonMap.containsKey(COUNT)) {
            jsonMap[COUNT] as Int
        } else 1
    }
}