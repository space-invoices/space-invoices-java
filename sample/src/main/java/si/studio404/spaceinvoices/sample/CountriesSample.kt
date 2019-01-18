package si.studio404.spaceinvoices.sample

import si.studio404.spaceinvoices.SpaceInvoices

fun main(args: Array<String>) {

    // this call returns token / LAUNCH_CODE
    val token = TokenProvider.getToken()

    // set testing to true to run on test backend
    val si = SpaceInvoices(token, testing = true)
    println("token = ${si.token}")

    val countries = si.getCountries()
    println("countries = ${countries.joinToString()}")

}