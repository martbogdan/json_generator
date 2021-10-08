package com.supper.generator.service

import com.supper.generator.replacer.ReplacerChain
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
internal class VariableServiceTest(@Autowired val replacer: ReplacerChain) {

    val json = """{
  "@count": 5,
  "@var": "var",
  "@var(arr)": ["v1", "v2"],
  "@var(arrArr)": [["v1", "v2"], ["v1", "v2"], ["v1", "v2"]],
  "firstname": "@firstname",
  "lastname": "@lastname",
  "address": "@address"

}"""

    @Test
    fun getVariables() {
        val varService: VariableService = VariableService(ReplaceService(replacer))
        val result = varService.getVariables(json)
        println(result)
    }
}