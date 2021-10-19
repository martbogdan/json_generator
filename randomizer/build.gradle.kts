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
            artifactId = "randomizer"
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
    implementation(project(":custom-faker"))
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    testImplementation("org.springframework.boot:spring-boot-starter-test")

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