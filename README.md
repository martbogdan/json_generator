# Generator Library
Spring boot library for generating random json data from template

# Instruction
* add dependency to your project
```
Maven: 
 <dependency>
     <groupId>io.github.martbogdan</groupId>
     <artifactId>generator</artifactId>
     <version>0.0.4</version>
     <type>pom</type>
 </dependency>
Gradle:
 implementation 'io.github.martbogdan:generator:0.0.4'
```
* import Beans from the library into your configuration class
```
JAVA:
    @Configuration
    @Import(GeneratorConfiguration.class)
    public class Configurations {
         ...
    }

KOTLIN:
    @Configuration
@Import(GeneratorConfiguration::class)
class Configuration
```
* Autowire bean ```Generator``` into your component and use method ```generateData(String json, Integer count)``` 
  which takes parameters ```json template as String``` and ```number of generated objects as Integer``` returns ```Iterator<Object>```
```
  EXAMPLE OF USING IN CONTROLLER TO GENERATE LIST OF JSON OBJECTS:
  
  JAVA:
  @GetMapping("/generateList")
  public List<Object> getJsonList(@RequestBody String json, @RequestParam(required = false) Integer count) {
        List<Object> result = new ArrayList<>();
        generator.generateData(jsonStr, count).forEachRemaining(result::add);
        return result;
    }
  
  KOTLIN:
  @GetMapping(value = ["/generateList"])
  fun getPatients(@RequestBody jsonObject: String, @RequestParam(required = false) count: Int?): List<Any> =
      generator.generateData(jsonObject, count).asSequence().toList()
```
# Available functions:
* @count - number of json objects will be generated.
* @var - set of variables for generating
* @firstname - generates random first name
* @lastname - generates random last name
* @date - generates random date from '1900-01-01' until now
* @date(FROM, UNTIL) - generates random date from 'FROM' until 'UNTIL'
* @number - generates random Integer from -2147483648 until 2147483647
* @number(FROM, UNTIL) - generates random Integer from 'FROM' until 'UNTIL'
* @oneOf(1, 2, 3, 4), @oneOf([1, 2, 3]) @oneOf([[1, 2], [3, 4]]) - generates random one value of giver array as parameter
* @oneAt(0, [1, 2, 3]) - returns value at index from array (first parameter is index of element in array as second parameter)
* @manyOf(3, [1, 2, 3, 4, 5, 6, 7]) - returns random number (from 0 until value as first param) of values from array as second param
* @Str(40) - returns random string of length 40 (9k6L8VFPBvCrvDI7wTUuEP0LfaWUXQ1FfOVp90rs)

References in function parameters:
* '#examppleField' - will return from given or already generated json field 
 (Example: { "date1": "2021-01-01", "date2": "@date(#date1, 2021-12-05)" }, field "date2" will be in range 2021-01-01 : 2021-12-05)
*
Example:
given template will generate next JSON
```
# Template:
{
  "@var": {
    "var1": "var",
    "varArray": ["v1", "v2", "v3", "v4", "v5", "v6"],
    "varArrays": [["d1", "c1"], ["d2", "c2"], ["v3", "c3"], ["v4", "c4"], ["v5", "c5"], ["v6", "c6"]],
    "oneFromArray": "@oneOf(#varArrays)" 
    },
  "firstname": "@firstname",
  "lastname": "@lastname",
  "date1": "@date",
  "date2": "@date(2020-12-05, 2021-09-01)",
  "date3": "@date(#date1, 2021-12-05)",
  "number1": "@number",
  "number2": "@number(-200, 500)",
  "double1": "@double",
  "double2": "@double(10.000, 50.000)",
  "manyFromArray": "@manyOf(3, #varArray)",
  "randomArray": ["@firstname", "@lastname", "@date", "@number(1, 10)"],
  "oneFromVarArray": "@oneOf(#varArray)",
  "generatedArray": {
      "@count": 3,
      "firstname": "@firstname",
      "date": "@date"
  },
  "varData": "#oneFromArray",
  "oneAtData1": "@oneAt(0, #varData)",
  "oneAtData2": "@oneAt(1, #varData)",
  "child1": {
    "firstname1": "@firstname",
    "lastname": "@lastname",
    "child2": {
      "firstname2": "@firstname",
      "lastname": "@lastname",
      "child3": {
        "firstname": "@firstname",
        "lastname": "@lastname"
      }
    }
  }
}
# Result
[
    {
        "firstname": "Onfroi",
        "lastname": "Swan",
        "date1": "1955-08-25",
        "date2": "2021-05-09",
        "date3": "1981-12-30",
        "number1": 1644683481,
        "number2": 122,
        "double1": "400343.578",
        "double2": "41.964",
        "manyFromArray": [
            "v1",
            "v4"
        ],
        "randomArray": [
            "Emilia",
            "Gopsell",
            "1969-03-05",
            5
        ],
        "oneFromVarArray": "v1",
        "generatedArray": [
            {
                "firstname": "Clevey",
                "date": "1924-12-11"
            },
            {
                "firstname": "Wyn",
                "date": "1947-03-19"
            },
            {
                "firstname": "Wyn",
                "date": "1937-02-09"
            }
        ],
        "varData": "[d2, c2]",
        "oneAtData1": "d2",
        "oneAtData2": "c2",
        "child1": {
            "firstname1": "Lexie",
            "lastname": "Mattevi",
            "child2": {
                "firstname2": "Gaby",
                "lastname": "Tommis",
                "child3": {
                    "firstname": "Henrietta",
                    "lastname": "Conley"
                }
            }
        }
    }
]
```

