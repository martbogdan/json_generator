package com.supper.generator

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import java.time.Duration
import java.time.LocalDateTime
import java.util.concurrent.ThreadLocalRandom

@SpringBootApplication
class GeneratorApplication

fun main(args: Array<String>) {
    runApplication<GeneratorApplication>(*args)
}

@RestController
class RestController {

    @GetMapping(value = ["/generate"])
    fun getPatients(@RequestBody jsonObject: String ): List<Any> {
        var count = 1
        val jsonMap = jsonObject as Map<*, *>
        if (jsonMap.toMap().containsKey("@count")) {
            count = jsonMap["@count"] as Int
        }

        val listPatients = mutableListOf<Any>()
        repeat(count) {
            listPatients.add(replaceValues(jsonMap))
        }
        return listPatients
    }

    fun replaceValues(jsonMap: Map<*, *>): HashMap<Any?, Any?> {
        var jjj = jsonMap.filterKeys { k -> k != "@count" }.toMutableMap() as HashMap<Any?, Any?>
        for (v in jjj.entries) {
            when (v.value) {
                "@name" -> {
                    jjj[v.key] = getRandomName()
                }
                else -> {
                    jjj[v.key] = replaceValues(v.value as Map<*, *>)
                }
            }
        }
        return jjj
    }



    @GetMapping(value = ["/stocks/{symbol}"], produces = [MediaType.TEXT_EVENT_STREAM_VALUE])
    fun prices(@PathVariable symbol: String): Flux<StockPrice> {
        return Flux.interval(Duration.ofSeconds(1))
            .map { StockPrice(symbol, randomStockPrice(), LocalDateTime.now()) }
    }

    private fun randomStockPrice(): Double {
        return ThreadLocalRandom.current().nextDouble(100.00 )
    }
}

data class StockPrice (val symbol: String,
                       val price: Double,
                       val time: LocalDateTime)
