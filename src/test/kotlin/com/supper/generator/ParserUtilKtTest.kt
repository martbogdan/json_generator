package com.supper.generator

import org.junit.jupiter.api.Test

import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
internal class ParserUtilKtTest() {

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

        println("Result")
        println(ParserUtil().parseJsonToMap(json))

    }
}