package io.github.martbogdan.generator.service

import io.github.martbogdan.generator.replacer.ReplacerChain
import org.junit.jupiter.api.Test

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest(classes = [io.github.martbogdan.generator.GeneratorConfiguration::class])
internal class ReferenceServiceTest(@Autowired val replacerChain: ReplacerChain) {

    private val replaceService = ReplaceService(replacerChain)
    private val referenceService = ReferenceService(replaceService)



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
    val json4 = """{
  "@count": 1,
  "firstname": "@firstname",
  "lastname": "@lastname",
  "address": "@address",
  "notreplace": "@donotreplace",
  "date1": "@date",
  "date": "@date",
  "date2": "@date(2020-12-05, 2021-09-01)",
  "date3": "@date(#date1, 2021-12-05)",
  "number": "@number(#num2, 500 ,false)",
  "number55": "@number(2 , 500 ,false)",
  "num2": "@number(1, #number55,   false  )",
   "someArray": ["#date", "#date1", "#date2", "#date3"],
  "someArray1": [
    "aa",
    "bb",
    "cc"
  ],
  "someArray2": [
    "@number",
    2,
    "@number(-100 , 500 ,false)"
  ],
  "someArray3": [
    {
      "child3": {
        "firstname": "@firstname",
        "lastname": "@lastname",
        "address": "@address"
      }
    },
    {
      "child3": {
        "firstname": "@firstname",
        "lastname": "@lastname"
      }
    },
    {
      "child3": {
        "firstname": "@firstname",
        "lastname": "@lastname"
      }
    }
  ],
  "someArray4": [
    {
      "someArray1": [
        "aa",
        "bb",
        "@firstname",
        "@lastname",
        "@address"
      ]
    },
    {
      "someArray2": [
        "@firstname",
        "@lastname",
        2,
        3
      ]
    }
  ],
  "child1": {
    "firstname1": "@firstname",
    "lastname": "@lastname",
    "child2": {
      "firstname2": "@firstname",
      "lastname": "@lastname",
      "address": "@address",
      "child3": {
        "firstname": "@firstname",
        "lastname": "@lastname"
      }
    }
  }
}"""

    @Test
    fun getReferencesMap() {
    }

    @Test
    fun getReferencesTest() {
        val expected = setOf("date1", "date2", "date")
        val actual = referenceService.getReferences(json3)
        println("expected: $expected ; actual: $actual")
        assert(expected == actual)
    }

    @Test
    fun initRefValuesTest() {
        val set = referenceService.getReferences(json4)
        val map = replaceService.parseJsonToMap(json4)
        println(map)
        val mapResult = referenceService.initRefValues(set, map)
        println(mapResult)
    }
}