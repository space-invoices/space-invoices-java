package si.studio404.spaceinvoices.sample

import si.studio404.spaceinvoices.SpaceInvoices
import si.studio404.spaceinvoices.model.Organization

fun main(args: Array<String>) {

    // this call returns token / LAUNCH_CODE
    val token = TokenProvider.getToken()
    // this call returns accountId - received on login
    val accountId = TokenProvider.getAccountId()

    // set testing to true to run on test backend
    val si = SpaceInvoices(token, testing = true)
    println("token = ${si.token}")

    val organizations = si.getOrganizations(accountId)
    println("organizations = ${organizations.joinToString()}")

    val organization = si.getOrganization(organizations.first().organizationId)
    println("organization = $organization")

    val newOrganization = si.createOrganization(accountId, Organization(name = "SpaceX", country = "USA"))
    println("newOrganization = $newOrganization")

    // TODO: add logo

    // TODO: add signature

}
