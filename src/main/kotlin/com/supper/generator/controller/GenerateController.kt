package com.supper.generator.controller

import com.supper.generator.service.GenerateService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class GenerateController(@Autowired val generateService: GenerateService) {

    @GetMapping(value = ["/generate"])
    fun getPatients(@RequestBody jsonObject: String, @RequestParam(required = false) count: Int?): List<Any> =
        generateService.generateJsonList(jsonObject, count)

}