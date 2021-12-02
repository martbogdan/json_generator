package io.github.martbogdan.generator

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

const val COUNT = 1000

@SpringBootTest(classes = [io.github.martbogdan.generator.GeneratorConfiguration::class])
internal class GeneratorTest(@Autowired val generator: io.github.martbogdan.generator.Generator) {
    val template = """{
  "@count": 1,
  "@var": {
    "dicNameCode": [["d1", "c1"], ["d2", "c2"], ["v3", "c3"], ["v4", "c4"], ["v5", "c5"], ["v6", "c6"], ["v7", "c7"], ["v8", "c8"]],
    "vitalArr": [["vd1", "vc1"], ["vd2", "vc2"], ["vd3", "vc3"], ["vd4", "vc4"], ["vd5", "vc5"], ["vd6", "vc6"], ["vd7", "vc7"], ["vd8", "vc8"]],
    "dicCode1": "@oneOf(#dicNameCode)",
    "dicVit" : "@oneOf(#vitalArr)",
    "listOfTest" : "@listOf(3, {fn: @firstname})",
    "exper": {
        
        "fn": "@firstname"
    }
  },
  "ex": "#exper",
  "exper2": {
        "@count": 5,
        "fn": "@firstname"
    },
  "firstname": "@firstname",
  "lastname": "@lastname",
  "dob": "@date",
  "dod": "@date(#dob, now)",
  "regDate": "@date(#dob, #dod)",
  "randNum": "@number(1, 500)",
  "randDouble": "@double(1, 500)",
  "listOfTestResult": "#listOfTest",
  "listOfTest1" : "@listOf(3, {fn: @firstname})",
  "string": "@string(40)",
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

    val template2 = """{
  "@count": 1,
  "array5": {
        "@count": 5,
        "fn": "@firstname"
    },
  "oneFromArray": "#array5"
}"""
    @Test
    fun generateDataTest() {
        val result = generator.generateData(template, COUNT)
        val size = result.asSequence().count()
        println(size)
        assert(COUNT == size)
    }

    @Test
    fun generateDataElementTest() {
        val result = generator.generateData(template, COUNT)
        val list = result.asSequence().toList()

        println(list[0])
        println(list[1])
        assert(list[0] != list[1])
    }

    @Test
    fun generateDataMemoryTest() {
        val result = generator.generateData(template, COUNT)
        while (result.hasNext()) {
            result.next()
        }
    }

    @Test
    fun generateCountTest() {
        val result = generator.generateData(template2, COUNT)
        val list = result.asSequence().toList()

        val map = list[0] as HashMap<String, Any?>
        println(list[0])
        println(map["array5"])
        assert(5 == (map["array5"] as List<Any?>).size)
    }

}