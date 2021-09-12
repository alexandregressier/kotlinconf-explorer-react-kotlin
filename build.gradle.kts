import org.jetbrains.kotlin.gradle.targets.js.nodejs.NodeJsRootExtension

plugins {
    kotlin("js")
}

group = "dev.gressier"
version = "0.1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    implementation("org.jetbrains.kotlin-wrappers:kotlin-react:_")
    implementation("org.jetbrains.kotlin-wrappers:kotlin-react-dom:_")
    implementation("org.jetbrains.kotlin-wrappers:kotlin-styled:_")
}

kotlin {
    js(IR) {
        binaries.executable()
        browser {
            commonWebpackConfig {
                cssSupport.enabled = true
            }
        }
    }
}

afterEvaluate {
    rootProject.extensions.configure<NodeJsRootExtension> {
        versions.webpackDevServer.version = "${project.extra["version.webpackDevServer"]}"
    }
}

tasks.withType<Wrapper> {
    gradleVersion = "${project.extra["version.gradle"]}"
}