package com.supper.generator.service

import com.supper.generator.replacer.ReplacerChain
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.mockito.Mock
import org.mockito.Spy
import org.springframework.beans.factory.annotation.Autowired

internal class ReferenceServiceTest(@Autowired val replacer: ReplacerChain) {
    val replaceService = ReplaceService(replacer)
    val referenceService = ReferenceService(replaceService)



    val json3 =
        """{  
   "@count": 5,
   "num1": "@number",
   "date": "2021/01/01",
   "date1": "@date",
   "date2": "@date(#date1, 2021/09/01)",
   "num2": "@number(1, #date2,   false  )",
   "someArray": ["#date", "#date1", "#date2"]
}"""

    @Test
    fun getReferencesMap() {
    }

    @Test
    fun getReferencesTest() {
        val expected = listOf("date1", "date2")
        val actual = referenceService.getReferences(json3)
        println("expected: $expected ; actual: $actual")
        assert(expected == actual)
    }

    @Test
    fun initRefValuesTest() {
        val list = referenceService.getReferences(json3)
        val map = replaceService.parseJsonToMap(json3)
        val mapResult = referenceService.initRefValues(list, map)
        println(mapResult)
    }
}