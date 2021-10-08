# Generator App
Spring boot Application for generating random json data from temlate
# Awailable functions:
* @count - number of json objects will be generated. Can be ignored if count added as parameter to the URL
* @firstname - generates random first name
* @lastname - generates random last name
* @date - generates random date from '1900-01-01' until now
* @date(FROM, UNTIL) - generates random date from 'FROM' until 'UNTIL'
* @number - generates random Integer from -2147483648 until 2147483647
* @number(FROM, UNTIL) - generates random Integer from 'FROM' until 'UNTIL'
*
References in function parameters:
* '#examppleField' - will return from given or already generated json field 
 (Example: { "date1": "2021-01-01", "date2": "@date(#date1, 2021-12-05)" }, field "date2" will be in range 2021-01-01 : 2021-12-05)
*
Example:
given template will generate array of 10 objects
```
# Template:
{
  "@count": 10,
  "firstname": "@firstname",
  "lastname": "@lastname",
  "date1": "@date",
  "date2": "@date(2020-12-05, 2021-09-01)",
  "date3": "@date(#date1, 2021-12-05)",
  "number1": "@number",
  "number2": "@number(-200, 500)",
  "number3": "@number(#number2, 600)",
  "someDateArray": ["#date1", "#date2", "#date3"],
  "someNumArray": ["@number", "#number1", "#number2", "#number3"],
  "someObjArray": [
    {
      "child1": {
        "firstname": "@firstname",
        "lastname": "@lastname",
        "dob": "@date"
      }
    },
    {
      "child2": {
        "firstname": "@firstname",
        "lastname": "@lastname",
        "dob": "@date"
      }
    }
  ],
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
[ {
        "firstname": "Pauli",
        "lastname": "Mines",
        "date1": "2015-08-08",
        "date2": "2021-07-24",
        "date3": "2019-03-11",
        "number1": -1351169150,
        "number2": 357,
        "number3": 577,
        "someDateArray": [
            "2015-08-08",
            "2021-07-24",
            "2019-03-11"
        ],
        "someNumArray": [
            -480018325,
            -1351169150,
            357,
            577
        ],
        "someObjArray": [
            {
                "child1": {
                    "firstname": "Loydie",
                    "lastname": "Haggerty",
                    "dob": "1982-05-09"
                }
            },
            {
                "child2": {
                    "firstname": "Hubie",
                    "lastname": "Janata",
                    "dob": "1900-09-17"
                }
            }
        ],
        "child1": {
            "firstname1": "Vaughan",
            "lastname": "Rosewall",
            "child2": {
                "firstname2": "Jammie",
                "lastname": "Pyott",
                "child3": {
                    "firstname": "Elyse",
                    "lastname": "Bagshaw"
                }
            }
        }
    } ...]
```
# User API
```
GET /generate HTTP/1.1
Host: localhost:8082
Content-Type: application/json
Content-Length: 1618

{
  "@count": 1,
  "firstname": "@firstname",
  "lastname": "@lastname",
  "address": "@address",
  "oneof": "@oneOf(#firstname, #date1, f, #num2, #child3, tttt)",

}
```
