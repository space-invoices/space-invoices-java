package si.studio404.spaceinvoices.sample

import si.studio404.spaceinvoices.SpaceInvoices

fun main(args: Array<String>) {

    // this call returns token / LAUNCH_CODE
    val token = TokenProvider.getToken()

    // create mock user credentials
    val email = "test${System.currentTimeMillis()}@examle.com"
    val password = "supersecret"

    // if testing is true it runs on test backend
    val si = SpaceInvoices(token, testing = true)
    println("token = ${si.token}")

    // create mock account
    val signupResponse = si.signup(email, password)
    println("signupResponse = $signupResponse")

    // login into mock account
    val loginResponse = si.login(email, password)
    println("loginResponse = $loginResponse")

    // get account info
    val accountResponse = si.getAccount(loginResponse.accountId)
    println("accountResponse = $accountResponse")

    // check, if passed email is unique
    val isUniqueResponse = si.isEmailUnique("rocketman@example.com")
    println("isUniqueResponse = $isUniqueResponse")

}
