package com.supper.generator

import org.junit.jupiter.api.Test

import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
internal class ParserUtilKtTest {

    @Test
    fun traverseJson() {
        val json = """{
  "@count": 5,
  "name": "@name",
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
        "name": "@name"
      }
    },
    {
      "child3": {
        "name": "@name"
      }
    },
    {
      "child3": {
        "name": "@name"
      }
    }
  ],
  "someArray4": [
    {
      "someArray1": [
        "aa",
        "bb",
        "@name"
      ]
    },
    {
      "someArray2": [
        "@name",
        2,
        3
      ]
    }
  ],
  "child1": {
    "name1": "@name",
    "child2": {
      "name2": "@name",
      "child3": {
        "name": "@name"
      }
    }
  }
}"""

        println("Result")
        println(parseJsonToMap(json))

    }
}