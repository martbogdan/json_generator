package com.supper.generator.config

import com.supper.randomizer.*
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class Config {
    @Bean
    fun firstNameRandomizer(): FirstNameRandomizer = FirstNameRandomizerImpl()

    @Bean
    fun lastNameRandomizer(): LastNameRandomizer = LastNameRandomizerImpl()

    @Bean
    fun numberRandomizer(): NumberRandomizer = NumberRandomizerImpl()

    @Bean
    fun dateRandomizer(): DateRandomizer = DateRandomizerImpl()

    @Bean
    fun doubleRandomizer(): DoubleRandomizer = DoubleRandomizerImpl()
}