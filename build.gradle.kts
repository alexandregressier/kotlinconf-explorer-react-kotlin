plugins {
    kotlin("js") version "1.5.10"
}

group = "dev.gressier"
version = "0.1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    implementation("org.jetbrains.kotlin-wrappers:kotlin-react:17.0.2-pre.206-kotlin-1.5.10")
    implementation("org.jetbrains.kotlin-wrappers:kotlin-react-dom:17.0.2-pre.206-kotlin-1.5.10")
    implementation("org.jetbrains.kotlin-wrappers:kotlin-styled:5.3.0-pre.206-kotlin-1.5.10")
}

kotlin {
    js(IR) {
        binaries.executable()
        browser {}
    }
}

tasks.withType<Wrapper> {
    gradleVersion = "${project.extra["version.gradle"]}"
}