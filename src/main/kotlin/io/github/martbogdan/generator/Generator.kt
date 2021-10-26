package io.github.martbogdan.generator

import io.github.martbogdan.generator.service.GenerateService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class Generator(@Autowired val generateService: GenerateService) {

    fun generateJsonDataList(template: String, count: Int?): List<Any> {
        return generateService.generateJsonList(template, count)
    }
}
