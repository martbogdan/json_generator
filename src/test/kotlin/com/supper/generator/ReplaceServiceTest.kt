package com.supper.generator

import com.supper.generator.replacer.ReplacerChain
import com.supper.generator.service.ReplaceService
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired

import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
internal class ReplaceServiceTest(@Autowired val replacer: ReplacerChain) {

    @Test
    fun traverseJson() {
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
  "num2": "@number(1 , 100 ,false)"
}"""

        println("Result")
        println(ReplaceService(replacer).processReplace(json2))

    }
}