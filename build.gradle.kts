plugins {
    kotlin("jvm") version "1.6.10"
    `java-gradle-plugin`
    `maven-publish`
}

group = "com.github.mrbean355"
version = "1.0.0-SNAPSHOT"

repositories {
    mavenCentral()
    google()
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation(kotlin("gradle-plugin"))
    implementation("com.android.tools.build:gradle:7.1.3")
    implementation("com.squareup:kotlinpoet:1.11.0")

    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.2")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}

gradlePlugin {
    plugins {
        create("featureTogglesPlugin") {
            id = "com.github.mrbean355.featuretoggles"
            implementationClass = "com.github.mrbean355.featuretoggles.FeatureTogglesPlugin"
        }
    }
}