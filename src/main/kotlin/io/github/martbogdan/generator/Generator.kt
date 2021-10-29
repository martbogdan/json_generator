package io.github.martbogdan.generator

import io.github.martbogdan.generator.service.GenerateService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class Generator(@Autowired val generateService: GenerateService) {

    fun generateData(template: String, count: Int?): Iterator<Any> {
        return generateService.generateJson(template, count)
    }
}
