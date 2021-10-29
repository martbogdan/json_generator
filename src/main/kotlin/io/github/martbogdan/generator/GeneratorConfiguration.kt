package io.github.martbogdan.generator

import io.github.martbogdan.randomizer.*
import io.github.martbogdan.randomizer.fakedata.FirstNameFaker
import io.github.martbogdan.randomizer.fakedata.LastNameFaker
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration

@Configuration
@ComponentScan
class GeneratorConfiguration {

    @Bean
    fun firstNameFaker(): FirstNameFaker = FirstNameFaker()

    @Bean
    fun lastNameFaker(): LastNameFaker = LastNameFaker()

    @Bean
    fun firstNameRandomizer(): FirstNameRandomizer = FirstNameRandomizerImpl(firstNameFaker())

    @Bean
    fun lastNameRandomizer(): LastNameRandomizer = LastNameRandomizerImpl(lastNameFaker())

    @Bean
    fun numberRandomizer(): NumberRandomizer = NumberRandomizerImpl()

    @Bean
    fun dateRandomizer(): DateRandomizer = DateRandomizerImpl()

    @Bean
    fun doubleRandomizer(): DoubleRandomizer = DoubleRandomizerImpl()

}


