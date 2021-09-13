package com.supper.generator

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
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


// NOT for this APP
@RestController
class RestController(@Autowired val parserUtil: ParserUtil) {

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
