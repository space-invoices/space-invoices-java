package si.studio404.spaceinvoices.rest

import okhttp3.OkHttpClient
import si.studio404.spaceinvoices.model.response.Organization
import si.studio404.spaceinvoices.model.request.LoginRequest
import si.studio404.spaceinvoices.model.request.SignupRequest
import si.studio404.spaceinvoices.model.response.AccountDetails
import si.studio404.spaceinvoices.model.response.LoginResponse
import si.studio404.spaceinvoices.model.response.SignupResponse
import si.studio404.spaceinvoices.model.response.UniqueEmailResponse

internal class SpaceApi(
    token: String,
    httpClient: OkHttpClient?,
    testing: Boolean
) {

    private val rest = SpaceRest(httpClient)

    private val baseUrl = if (testing)
        "https://api-test.spaceinvoices.com/v1"
    else
        "https://api.spaceinvoices.com/v1"

    private val accountsUrl         get() = "$baseUrl/accounts"
    private val organizationsUrl    get() = "$baseUrl/organizations"
    private val documentsUrl        get() = "$baseUrl/documents"
    private val countriesUrl        get() = "$baseUrl/countries"
    private val currenciesUrl       get() = "$baseUrl/currencies"
    private val clientsUrl          get() = "$baseUrl/clients"
    private val companiesUrl        get() = "$baseUrl/companies"
    private val itemsUrl            get() = "$baseUrl/items"
    private val paymentsUrl         get() = "$baseUrl/payments"
    private val recurrencesUrl      get() = "$baseUrl/recurrences"
    private val taxesUrl            get() = "$baseUrl/taxes"

    private val authHeaders = mapOf("Authorization" to token)

    /*
     * ACCOUNT
     */

    fun signup(email: String, password: String) = rest.post<SignupResponse>(
        url = accountsUrl,
        headers = authHeaders,
        body = SignupRequest(email, password)
    )

    fun login(email: String, password: String) = rest.post<LoginResponse>(
        url = "$accountsUrl/login",
        headers = authHeaders,
        body = LoginRequest(email, password)
    )

    fun isEmailUnique(email: String) = rest.get<UniqueEmailResponse>(
        url = "$accountsUrl/is-unique?email=$email",
        headers = authHeaders
    )

    fun getAccountDetails(accountId: String) = rest.get<AccountDetails>(
        url = "$accountsUrl/$accountId",
        headers = authHeaders
    )

    /*
     * ORGANIZATION
     */

    fun getOrganizationDetails(organizationId: String) = rest.get<Organization>(
        url = "$organizationsUrl/$organizationId",
        headers = authHeaders
    )

    fun getOrganizations(accountId: String) = rest.get<Array<Organization>>(
        url = "$accountsUrl/$accountId/organizations",
        headers = authHeaders
    )

}
