import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("maven-publish")
    id("org.springframework.boot")
    id("io.spring.dependency-management")
    kotlin("jvm")
    kotlin("plugin.spring")
}

group = "com.supper"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

publishing {
    publications {
        create<MavenPublication>("maven") {
            groupId = "com.supper"
            artifactId = "generator"
            version = "0.0.1-SNAPSHOT"

            from(components["java"])
        }
    }
}

repositories {
    mavenLocal()
    mavenCentral()
}

dependencies {
    implementation(project(":randomizer"))
    implementation(project(":custom-faker"))
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("io.projectreactor.kotlin:reactor-kotlin-extensions")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor")
    developmentOnly("org.springframework.boot:spring-boot-devtools")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("io.projectreactor:reactor-test")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "11"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

tasks.bootJar { enabled = false}
