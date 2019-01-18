import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlinJvm()
}

repositories {
    mavenCentral()
}

dependencies {
    compile(project(":library"))
    compile(Depends.Kotlin.stdlib)
}
