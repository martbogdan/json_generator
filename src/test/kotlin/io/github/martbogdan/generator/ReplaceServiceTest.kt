package io.github.martbogdan.generator

import io.github.martbogdan.generator.replacer.ReplacerChain
import io.github.martbogdan.generator.service.ReplaceService
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired

import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest(classes = [io.github.martbogdan.generator.GeneratorConfiguration::class])
internal class ReplaceServiceTest(@Autowired val replacer: ReplacerChain) {
    val replaceService = ReplaceService(replacer)

    val json = """{
  "@count": 5,
  "firstname": "@firstname",
  "lastname": "@lastname",
  "address": "@address",
  "notreplace": "@donotreplace",
  "someArray1": [
    "aa",
    "bb",
    "cc"
  ],
  "someArray2": [
    1,
    2,
    3
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
    val json2 = """{
  "@count": 5,
  "num1": "@number",
  "num2": "@number( 1  ,    100    ,   false  )"
}"""
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
    fun traverseJson() {
        println("Result")
        println(replaceService.processReplace(json))
    }


}