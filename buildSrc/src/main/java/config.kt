import org.gradle.plugin.use.PluginDependenciesSpec

object Application {
    const val groupId = "si.studio404"
    const val versionCode = 0
    const val versionName = "0.0.1"
}

object Versions {

    /* Kotlin */
    const val kotlin = "1.3.11"

    /* Network */
    const val okhttp = "3.12.1"

    /* Misc */
    const val gson = "2.8.5"
    const val clikt = "1.6.0"

    /* Test */
    const val junit = "4.12"
}

object Depends {

    object Kotlin {
        const val stdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.kotlin}"
    }

    object Network {
        const val okhttp = "com.squareup.okhttp3:okhttp:${Versions.okhttp}"
        const val okhttpInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.okhttp}"
    }

    object Misc {
        const val gson = "com.google.code.gson:gson:${Versions.gson}"
        const val clikt = "com.github.ajalt:clikt:${Versions.clikt}"
    }

    object Test {
        const val jUnit = "junit:junit:${Versions.junit}"
    }
}

fun PluginDependenciesSpec.kotlinJvm() = id("org.jetbrains.kotlin.jvm").version(Versions.kotlin)
