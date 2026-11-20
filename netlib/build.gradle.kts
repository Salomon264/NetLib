import org.gradle.api.publish.PublishingExtension
import org.gradle.api.publish.maven.MavenPublication

plugins {
    alias(libs.plugins.android.library)
    id("org.jetbrains.kotlin.plugin.serialization") version "2.2.10"
    id("maven-publish")
}

android {
    namespace = "com.example.netlib"
    compileSdk { version = release(37) }

    defaultConfig {
        minSdk = 24
    }

    publishing {
        singleVariant("release") { withSourcesJar() }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {
    api("com.squareup.retrofit2:retrofit:2.11.0")
    api("com.squareup.retrofit2:converter-kotlinx-serialization:2.11.0")
    api("com.squareup.okhttp3:okhttp:4.12.0")
    api("org.jetbrains.kotlinx:kotlinx-serialization-json:1.7.3")
}

afterEvaluate {
    extensions.configure<PublishingExtension>("publishing") {
        publications {
            register<MavenPublication>("release") {
                from(components["release"])
                groupId = "com.github.Salomon264"
                artifactId = "netlib"
                version = "1.0.0"
            }
        }
    }
}