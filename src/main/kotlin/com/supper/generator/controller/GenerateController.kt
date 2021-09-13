package com.supper.generator.controller

import com.supper.generator.ParserUtil
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class GenerateController(@Autowired val parserUtil: ParserUtil) {

    val logger: Logger = LoggerFactory.getLogger(javaClass)

    @GetMapping(value = ["/generate"])
    fun getPatients(@RequestBody jsonObject: String, @RequestParam(required = false) count: Int? ): List<Any> {
        val start = System.currentTimeMillis()

        val countTimes = parserUtil.getCount(jsonObject, count)

        val listPatients = mutableListOf<Any>()
        repeat(countTimes) {
            listPatients.add(parserUtil.processReplace(jsonObject))
        }

        val end = System.currentTimeMillis()
        logger.info("Time for $countTimes objects is ${end - start} ms")
        return listPatients
    }
}