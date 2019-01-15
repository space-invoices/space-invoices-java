import org.gradle.plugin.use.PluginDependenciesSpec

object Application {
    const val groupId = "si.studio404"
    const val versionCode = 0
    const val versionName = "0.0.1"
}

object Versions {

    /* Kotlin */
    const val kotlin = "1.3.11"

    /* Test */
    const val junit = "4.12"
}

object Depends {

    /* Kotlin */
    const val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.kotlin}"

    object Test {
        const val jUnit = "junit:junit:${Versions.junit}"
    }
}

fun PluginDependenciesSpec.kotlinJvm() = id("org.jetbrains.kotlin.jvm").version(Versions.kotlin)
