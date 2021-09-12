plugins {
    kotlin("js")
}

group = "dev.gressier"
version = "0.1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

fun kotlinw(target: String): String =
    "org.jetbrains.kotlin-wrappers:kotlin-$target"

dependencies {
    implementation(enforcedPlatform(kotlinw("wrappers-bom:_")))

    implementation(kotlinw("react"))
    implementation(kotlinw("react-dom"))
    implementation(kotlinw("styled"))

    implementation(npm("react-youtube-lite", "_"))
    implementation(npm("react-share", "_"))

    implementation(KotlinX.coroutines.core)
}

kotlin {
    js(IR) {
        browser {
            commonWebpackConfig {
                cssSupport.enabled = true
            }
        }
        binaries.executable()
    }
}

tasks.wrapper {
    gradleVersion = "${project.extra["version.gradle"]}"
}