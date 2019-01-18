package si.studio404.spaceinvoices

import okhttp3.OkHttpClient
import si.studio404.spaceinvoices.model.Organization
import si.studio404.spaceinvoices.model.Account
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

    // this does not require token
    fun login(email: String, password: String): LoginResponse {
        return api.login(email, password)
    }

    // this does not require token
    fun isEmailUnique(email: String): Boolean {
        return api.isEmailUnique(email).isUnique
    }

    fun signup(email: String, password: String): SignupResponse {
        return api.signup(email, password)
    }

    fun getAccountDetails(accountId: String): Account {
        return api.getAccount(accountId)
    }

    /*
     * ORGANIZATION
     */

    fun getOrganizations(accountId: String): Array<Organization> {
        return api.getOrganizations(accountId)
    }

    fun getOrganizationDetails(organizationId: String): Organization {
        return api.getOrganization(organizationId)
    }

    fun createOrganization(organizationId: String, organization: Organization): Organization {
        return api.createOrganization(organizationId, organization)
    }

}
