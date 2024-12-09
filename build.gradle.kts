import org.jetbrains.kotlin.gradle.dsl.KotlinJvmProjectExtension

plugins {
    id("java")
    kotlin("jvm")
}

group = "edu.bogdan.zaiats"
version = "Lab6"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains:annotations:24.0.0")
    implementation(platform("org.apache.logging.log4j:log4j-bom:2.24.2"))
    implementation("org.apache.logging.log4j:log4j-api:2.24.2")
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(23)
}