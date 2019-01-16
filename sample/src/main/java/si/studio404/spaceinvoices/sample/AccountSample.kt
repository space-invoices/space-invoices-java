package si.studio404.spaceinvoices.sample

import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.parameters.options.default
import com.github.ajalt.clikt.parameters.options.option
import com.github.ajalt.clikt.parameters.options.required
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import si.studio404.spaceinvoices.SpaceInvoices
import java.util.concurrent.TimeUnit

fun main(args: Array<String>) = AccountSample().main(args)

class AccountSample : CliktCommand() {

    private val token by option(help = "Token - LAUNCH_CODE").required()
    private val accountId by option(help = "User's ID").required()

    private val email by option(help = "User's email").required()
    private val password by option(help = "User's password").required()

    private val testing by option(help = "Run in 'test' mode").default("TRUE")

//    private val httpClient = OkHttpClient.Builder().apply {
//        connectTimeout(30, TimeUnit.SECONDS)
//        writeTimeout(30, TimeUnit.SECONDS)
//        readTimeout(30, TimeUnit.SECONDS)
//        addInterceptor(HttpLoggingInterceptor().apply {
//            level = HttpLoggingInterceptor.Level.BASIC
//        })
//    }.build()

    override fun run() {
        val si = SpaceInvoices(token, testing = testing.toBoolean())
        println("token = ${si.token}")

        val loginResponse = si.login(email, password)
        println("loginResponse = $loginResponse")

//        val signupResponse = si.signup("fake@email.com", "CHANGEME")
//        println("signupResponse = $signupResponse")

        val isUniqueResponse = si.isEmailUnique("fake@email.com")
        println("isUniqueResponse = $isUniqueResponse")

        val accountDetailsResponse = si.getAccountDetails(accountId/* or loginResponse.accountId */)
        println("accountDetailsResponse = $accountDetailsResponse")
    }

}
