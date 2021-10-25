import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("maven-publish")
    id("signing")
    id("org.springframework.boot")
    id("io.spring.dependency-management")
    kotlin("jvm")
    kotlin("plugin.spring")
}

group = "io.github.martbogdan"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

publishing {
    repositories {
        maven {
            name = "oss"
            val releasesRepoUrl = uri("https://s01.oss.sonatype.org/service/local/staging/deploy/maven2/")
            val snapshotsRepoUrl = uri("https://s01.oss.sonatype.org/content/repositories/snapshots/")
            url = if (version.toString().endsWith("SNAPSHOT")) snapshotsRepoUrl else releasesRepoUrl
        }
    }
    publications {
        withType<MavenPublication> {
            pom {
                name.set("generator")
                description.set("Generates list of JSON Objects")
                licenses {
                    license {
                        name.set("MIT")
                        url.set("https://opensource.org/licenses/MIT")
                    }
                }
                scm {
                    connection.set("https://github.com/martbogdan/json_generator.git")
                    url.set("https://github.com/martbogdan/json_generator")
                }
                developers {
                    developer {
                        name.set("Bogdan Martseniuk")
                        email.set("mbogdan0123@gmail.com")
                    }
                }
            }
//        create<MavenPublication>("maven") {
//            groupId = "com.supper"
//            artifactId = "generator"
//            version = "0.0.1-SNAPSHOT"
//
//            from(components["java"])
//        }
        }
    }
}

signing {
    useInMemoryPgpKeys(
        properties.getValue("ossrhUsername").toString(),
        properties.getValue("ossrhPassword").toString()
    )
    sign(publishing.publications)
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
