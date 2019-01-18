package si.studio404.spaceinvoices.sample

import si.studio404.spaceinvoices.SpaceInvoices

fun main(args: Array<String>) {

    // this call returns token / LAUNCH_CODE
    val token = TokenProvider.getToken()

    // create mock user credentials
    val email = "test${System.currentTimeMillis()}@example.com"
    val password = "supersecret"

    // set testing to true to run on test backend
    val si = SpaceInvoices(token, testing = true)
    println("token = ${si.token}")

    // create mock account
    val signupResponse = si.signup(email, password)
    println("signupResponse = $signupResponse")

    // login into created account
    val loginResponse = si.login(email, password)
    println("loginResponse = $loginResponse")

    // get created account info
    val accountResponse = si.getAccount(loginResponse.accountId)
    println("accountResponse = $accountResponse")

    // check, if passed email is unique
    val isUniqueResponse = si.isEmailUnique("rocketman@example.com")
    println("isUniqueResponse = $isUniqueResponse")

}
