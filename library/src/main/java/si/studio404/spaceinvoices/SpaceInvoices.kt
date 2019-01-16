package si.studio404.spaceinvoices

import okhttp3.OkHttpClient
import si.studio404.spaceinvoices.model.response.Organization
import si.studio404.spaceinvoices.model.response.AccountDetails
import si.studio404.spaceinvoices.model.response.LoginResponse
import si.studio404.spaceinvoices.model.response.SignupResponse
import si.studio404.spaceinvoices.rest.SpaceApi

class SpaceInvoices(
    val token: String,
    httpClient: OkHttpClient? = null,
    testing: Boolean = false
) {

    private val api = SpaceApi(token, httpClient, testing)

    /*
     * ACCOUNT
     */

    fun login(email: String, password: String): LoginResponse {
        return api.login(email, password)
    }

    fun signup(email: String, password: String): SignupResponse {
        return api.signup(email, password)
    }

    fun isEmailUnique(email: String): Boolean {
        return api.isEmailUnique(email).isUnique
    }

    fun getAccountDetails(accountId: String): AccountDetails {
        return api.getAccountDetails(accountId)
    }

    /*
     * ORGANIZATION
     */

    fun getOrganizations(accountId: String): Array<Organization> {
        return api.getOrganizations(accountId)
    }

    fun getOrganizationDetails(organizationId: String): Organization {
        return api.getOrganizationDetails(organizationId)
    }

}
