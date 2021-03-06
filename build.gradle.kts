buildscript {
    repositories {
        jcenter()
    }

    dependencies {
        classpath("com.novoda", "bintray-release", "0.9.2")
    }
}

plugins {
    kotlin("jvm") version "1.4.10"
}

apply(plugin = "com.novoda.bintray-release")

group = "com.ara.example"
version = "0.0.0"

repositories {
    mavenCentral()
}

configure<com.novoda.gradle.release.PublishExtension> {
    bintrayUser = System.getenv("BINTRAY_USER")
    bintrayKey = System.getenv("BINTRAY_API_KEY")

    userOrg = "siyual-park"
    groupId = group as String?
    repoName = "kotlin-dsl-gradle-publish"
    artifactId = "kotlin-dsl-gradle-publish"
    publishVersion = version as String?
    desc = "Example for publish with kotlin dsl"
    website = "https://github.com/siyual-park/kotlin-dsl-gradle-publish"
    dryRun = false
    override = true
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
}