package com.supper.generator

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest(classes = [GeneratorConfiguration::class])
internal class GeneratorTest(@Autowired val generator: Generator) {
    val template = """{
  "@count": 1,
  "@var": {
    "dicNameCode": [["d1", "c1"], ["d2", "c2"], ["v3", "c3"], ["v4", "c4"], ["v5", "c5"], ["v6", "c6"], ["v7", "c7"], ["v8", "c8"]],
    "vitalArr": [["vd1", "vc1"], ["vd2", "vc2"], ["vd3", "vc3"], ["vd4", "vc4"], ["vd5", "vc5"], ["vd6", "vc6"], ["vd7", "vc7"], ["vd8", "vc8"]],
    "dicCode1": "@oneOf(#dicNameCode)",
    "dicVit" : "@oneOf(#vitalArr)"
  },
  "firstname": "@firstname",
  "lastname": "@lastname",
  "dob": "@date",
  "dod": "@date(#dob, now)",
  "regDate": "@date(#dob, #dod)",
  "randNum": "@number(1, 500)",
  "randDouble": "@double(1, 500)",
  "medRec" : {
        "dicFull": "#dicCode1",
        "dicObj": {
            "dicName": "@oneAt(0, #dicCode1)",
            "dicCode": "@oneAt(1, #dicCode1)"
        },
        "vitFull": "#dicVit",
        "vitObj": {
            "vitName": "@oneAt(0, #dicVit)",
            "vitCode": "@oneAt(1, #dicVit)"
        }
  }
}"""
    @Test
    fun generateJsonDataList() {
        generator.generateJsonDataList(template, 5)
    }
}