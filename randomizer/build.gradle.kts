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
version = "0.0.4"
java.sourceCompatibility = JavaVersion.VERSION_11

publishing {
    repositories {
        maven {
            name = "oss"
            val releasesRepoUrl = uri("https://s01.oss.sonatype.org/service/local/staging/deploy/maven2/")
            val snapshotsRepoUrl = uri("https://s01.oss.sonatype.org/content/repositories/snapshots/")
            url = if (version.toString().endsWith("SNAPSHOT")) snapshotsRepoUrl else releasesRepoUrl
            credentials {
                username = properties.getValue("ossrhUsername").toString()
                password = properties.getValue("ossrhPassword").toString()
            }
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
                url.set("https://github.com/martbogdan/json_generator")
                issueManagement {
                    system.set("Github")
                    url.set("https://github.com/martbogdan/json_generator")
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
            groupId = "io.github.martbogdan"
            artifactId = "randomizer"
            version = "0.0.4"
        }
        create<MavenPublication>("maven") {
            groupId = "io.github.martbogdan"
            artifactId = "randomizer"
            version = "0.0.4"

            from(components["java"])
        }
    }
}

signing {
    useInMemoryPgpKeys(
        properties.getValue("GPG_SIGNING_KEY").toString(),
        properties.getValue("signing.password").toString()
    )
    sign(publishing.publications)
}

repositories {
    mavenLocal()
    mavenCentral()
}

dependencies {
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