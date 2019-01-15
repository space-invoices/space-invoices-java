import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlinJvm()
}

repositories {
    mavenCentral()
}

dependencies {
    compile(kotlin("stdlib"))
}
