import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlinJvm()
}

repositories {
    mavenCentral()
}

dependencies {
    compile(Depends.Kotlin.stdlib)
    compile(Depends.Network.okhttp)
    compile(Depends.Network.okhttpInterceptor)
    compile(Depends.Misc.gson)
}
