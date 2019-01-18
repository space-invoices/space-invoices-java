package si.studio404.spaceinvoices.rest

import okhttp3.OkHttpClient
import si.studio404.spaceinvoices.model.*
import si.studio404.spaceinvoices.model.request.LoginRequest
import si.studio404.spaceinvoices.model.request.SignupRequest
import si.studio404.spaceinvoices.model.response.*

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

    private val authHeader = "Authorization" to token

    /*
     * ACCOUNTS
     */

    fun signup(email: String, password: String) = rest.post<SignupResponse>(
        url = accountsUrl,
        headers = mapOf(authHeader),
        body = SignupRequest(email, password)
    )

    fun login(email: String, password: String) = rest.post<LoginResponse>(
        url = "$accountsUrl/login",
        headers = mapOf(authHeader),
        body = LoginRequest(email, password)
    )

    fun isEmailUnique(email: String) = rest.get<UniqueEmailResponse>(
        url = "$accountsUrl/is-unique?email=$email",
        headers = mapOf(authHeader)
    )

    fun getAccount(accountId: String) = rest.get<Account>(
        url = "$accountsUrl/$accountId",
        headers = mapOf(authHeader)
    )

    /*
     * ORGANIZATIONS
     */

    fun getOrganizations(accountId: String) = rest.get<Array<Organization>>(
        url = "$accountsUrl/$accountId/organizations",
        headers = mapOf(authHeader)
    )

    fun getOrganization(organizationId: String) = rest.get<Organization>(
        url = "$organizationsUrl/$organizationId",
        headers = mapOf(authHeader)
    )

    fun createOrganization(accountId: String, organization: Organization) = rest.post<Organization>(
        url = "$accountsUrl/$accountId/organizations",
        headers = mapOf(authHeader),
        body = organization
    )

//    fun addLogoToOrganization(organizationId: String) = rest.post<ImageUploadResponse>(
//        url = "$organizationsUrl/$organizationId/upload-image?type=logo",
//        headers = mapOf(authHeader),
//    )
//
//    fun addSignatureToOrganization(organizationId: String) = rest.post<ImageUploadResponse>(
//        url = "$organizationsUrl/$organizationId/upload-image?type=signature",
//        headers = mapOf(authHeader),
//    )

    /*
     * DOCUMENTS
     */

    fun getDocuments(organizationId: String) = rest.get<Array<Document>>(
        url = "$organizationsUrl/$organizationId/documents",
        headers = mapOf(authHeader)
    )

    fun getDocument(documentId: String) = rest.get<Document>(
        url = "$documentsUrl/$documentId",
        headers = mapOf(authHeader)
    )

    fun createDocument(organizationId: String, document: Document) = rest.post<Document>(
        url = "$organizationsUrl/$organizationId/documents",
        headers = mapOf(authHeader),
        body = document
    )

    fun updateDocument(documentId: String, document: Document) = rest.put<Document>(
        url = "$documentsUrl/$documentId",
        headers = mapOf(authHeader),
        body = document
    )

    fun deleteDocument(documentId: String) = rest.delete<DeleteResponse>(
        url = "$documentsUrl/$documentId",
        headers = mapOf(authHeader)
    )

//    fun getEnPdf(documentId: String) = rest.get<?>(
//        url = "$documentsUrl/$documentId/pdf?l=en",
//        headers = mapOf(authHeader)
//    )
//
//    fun getSlPdf(documentId: String) = rest.get<?>(
//        url = "$documentsUrl/$documentId/pdf?l=sl",
//        headers = mapOf(authHeader)
//    )
//
//    fun getDePdf(documentId: String) = rest.get<?>(
//        url = "$documentsUrl/$documentId/pdf?l=de",
//        headers = mapOf(authHeader)
//    )

//    fun sendEmail(documentId: String, recipients: List<String>, message: String, subject: String) = rest.post<SendEmailResponse>(
//        url = "$documentsUrl/$documentId/send",
//        headers = mapOf(authHeader),
//        body = SendEmailRequest(recipients, message, subject)
//    )

    /*
     * COUNTRIES
     */

    fun getCountries() = rest.get<Array<Country>>(
        url = countriesUrl,
        headers = mapOf(authHeader)
    )

    /*
     * CURRENCIES
     */

    fun getCurrencies() = rest.get<Array<Currency>>(
        url = currenciesUrl,
        headers = mapOf(authHeader)
    )

    /*
     * CLIENTS
     */

    fun getClients(organizationId: String) = rest.get<Array<Client>>(
        url = "$organizationsUrl/$organizationId/clients",
        headers = mapOf(authHeader)
    )

    fun searchClients(organizationId: String, query: String) = rest.get<Array<Client>>(
        url = "$organizationsUrl/$organizationId/search-clients?term=$query",
        headers = mapOf(authHeader)
    )

    fun getClient(clientId: String) = rest.get<Client>(
        url = "$clientsUrl/$clientId",
        headers = mapOf(authHeader)
    )

    fun createClient(organizationId: String, client: Client) = rest.post<Client>(
        url = "$organizationsUrl/$organizationId/clients",
        headers = mapOf(authHeader),
        body = client
    )

    fun updateClient(organizationId: String, client: Client) = rest.put<Client>(
        url = "$organizationsUrl/$organizationId/clients",
        headers = mapOf(authHeader),
        body = client
    )

    fun deleteClient(clientId: String) = rest.delete<DeleteResponse>(
        url = "$clientsUrl/$clientId",
        headers = mapOf(authHeader)
    )

    /*
     * COMPANIES
     */

    fun getCompanies() = rest.get<Array<Company>>(
        url = companiesUrl,
        headers = mapOf(authHeader)
    )

    fun searchCompanies(query: String) = rest.get<Array<Company>>(
        url = "$currenciesUrl/search?term=$query",
        headers = mapOf(authHeader)
    )

    /*
     * ITEMS
     */

    fun getItems(organizationId: String) = rest.get<Array<Item>>(
        url = "$organizationsUrl/$organizationId/items",
        headers = mapOf(authHeader)
    )

    fun searchItems(organizationId: String, query: String) = rest.get<Array<Item>>(
        url = "$organizationsUrl/$organizationId/search-items?term=$query",
        headers = mapOf(authHeader)
    )

    fun createItem(organizationId: String, item: Item) = rest.post<Item>(
        url = "$organizationsUrl/$organizationId/items",
        headers = mapOf(authHeader),
        body = item
    )

    fun updateItem(itemId: String, item: Item) = rest.put<Item>(
        url = "$itemsUrl/$itemId",
        headers = mapOf(authHeader),
        body = item
    )

    fun deleteItem(itemId: String) = rest.delete<DeleteResponse>(
        url = "$itemsUrl/$itemId",
        headers = mapOf(authHeader)
    )

    /*
     * PAYMENTS
     */

    fun getPayments(organizationId: String) = rest.get<Array<Payment>>(
        url = "$organizationsUrl/$organizationId/payments",
        headers = mapOf(authHeader)
    )

    fun getPaymentsForDocument(documentId: String) = rest.get<Array<Payment>>(
        url = "$documentsUrl/$documentId/payments",
        headers = mapOf(authHeader)
    )

    fun createPayment(documentId: String, payment: Payment) = rest.post<Payment>(
        url = "$documentsUrl/$documentId/payments",
        headers = mapOf(authHeader),
        body = payment
    )

    fun updatePayment(paymentId: String, payment: Payment) = rest.put<Payment>(
        url = "$paymentsUrl/$paymentId",
        headers = mapOf(authHeader),
        body = payment
    )

    fun deletePayment(paymentId: String) = rest.delete<DeleteResponse>(
        url = "$paymentsUrl/$paymentId",
        headers = mapOf(authHeader)
    )

    /*
     * RECURRENCES
     */

    fun getRecurrences(organizationId: String) = rest.get<Array<Recurrence>>(
        url = "$organizationsUrl/$organizationId/recurrences",
        headers = mapOf(authHeader)
    )

    fun getRecurrencesForDocument(documentId: String) = rest.get<Array<Recurrence>>(
        url = "$documentsUrl/$documentId/recurrence",
        headers = mapOf(authHeader)
    )

    fun createRecurrence(documentId: String, recurrence: Recurrence) = rest.post<Recurrence>(
        url = "$documentsUrl/$documentId/recurrence",
        headers = mapOf(authHeader),
        body = recurrence
    )

    fun deleteRecurrence(recurrenceId: String) = rest.delete<DeleteResponse>(
        url = "$recurrencesUrl/$recurrenceId",
        headers = mapOf(authHeader)
    )

    /*
     * TAXES
     */

    fun getTaxes(organizationId: String) = rest.get<Array<Tax>>(
        url = "$organizationsUrl/$organizationId/taxes",
        headers = mapOf(authHeader)
    )

    fun createTax(organizationId: String, tax: Tax) = rest.put<Tax>(
        url = "$organizationsUrl/$organizationId/taxes",
        headers = mapOf(authHeader),
        body = tax
    )

    fun addTaxRate(taxId: String, taxRate: TaxRate) = rest.put<TaxRate>(
        url = "$taxesUrl/$taxId/taxRates",
        headers = mapOf(authHeader),
        body = taxRate
    )

    fun updateTax(taxId: String, tax: Tax) = rest.put<Tax>(
        url = "$taxesUrl/$taxId",
        headers = mapOf(authHeader),
        body = tax
    )

    fun deleteTax(taxId: String) = rest.delete<DeleteResponse>(
        url = "$taxesUrl/$taxId",
        headers = mapOf(authHeader)
    )

}
