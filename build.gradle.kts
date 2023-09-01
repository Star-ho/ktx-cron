plugins {
    kotlin("jvm") version "1.9.0"
    application
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

tasks.jar {
    manifest.attributes["Main-Class"] = "MainKt"
    val dependencies = configurations
        .runtimeClasspath
        .get()
        .map(::zipTree) // OR .map { zipTree(it) }
    from(dependencies)
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
}


dependencies {
    implementation("org.jsoup:jsoup:1.15.3")
    implementation("com.github.pengrad:java-telegram-bot-api:6.8.0")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

    val ktorVersion = "2.1.3"
    // CIO request
    implementation("io.ktor:ktor-client-core:$ktorVersion")
    implementation("io.ktor:ktor-client-cio:$ktorVersion")
    implementation("io.ktor:ktor-serialization-kotlinx-json:$ktorVersion")
    implementation("io.ktor:ktor-client-content-negotiation:$ktorVersion")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")

    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(17)
}

application {
    mainClass.set("MainKt")
}