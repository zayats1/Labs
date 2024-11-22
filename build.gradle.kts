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
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation ("org.mockito:mockito-core:3.+" )
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(23)
}