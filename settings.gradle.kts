rootProject.name = "generator"
include("randomizer")
include("custom-faker")

pluginManagement {
    plugins {
        id("org.springframework.boot") version "2.5.5"
        id("io.spring.dependency-management") version "1.0.11.RELEASE"
        kotlin("jvm") version "1.5.31"
        kotlin("plugin.spring") version "1.5.31"
    }
}
