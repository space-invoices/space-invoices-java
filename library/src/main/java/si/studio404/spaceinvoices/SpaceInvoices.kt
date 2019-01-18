package si.studio404.spaceinvoices

import okhttp3.OkHttpClient
import si.studio404.spaceinvoices.model.*
import si.studio404.spaceinvoices.model.response.DeleteResponse
import si.studio404.spaceinvoices.model.response.LoginResponse
import si.studio404.spaceinvoices.model.response.SignupResponse
import si.studio404.spaceinvoices.rest.SpaceApi
import java.io.File

class SpaceInvoices(
    val token: String,
    httpClient: OkHttpClient? = null,
    testing: Boolean = false
) {

    private val api = SpaceApi(token, httpClient, testing)

    /*
     * ACCOUNTS
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

    fun getAccount(accountId: String): Account {
        return api.getAccount(accountId)
    }

    /*
     * ORGANIZATIONS
     */

    fun getOrganizations(accountId: String): Array<Organization> {
        return api.getOrganizations(accountId)
    }

    fun getOrganization(organizationId: String): Organization {
        return api.getOrganization(organizationId)
    }

    fun createOrganization(organizationId: String, organization: Organization): Organization {
        return api.createOrganization(organizationId, organization)
    }

    fun addLogoToOrganization(organizationId: String) {
        TODO()
    }

    fun addSignatureToOrganization(organizationId: String) {
        TODO()
    }

    /*
     * DOCUMENTS
     */

    fun getDocuments(organizationId: String): List<Document> {
        return api.getDocuments(organizationId).toList()
    }

    fun getDocument(documentId: String): Document {
        return api.getDocument(documentId)
    }

    fun createDocument(organizationId: String, document: Document): Document {
        return api.createDocument(organizationId, document)
    }

    fun updateDocument(documentId: String, document: Document): Document {
        return api.updateDocument(documentId, document)
    }

    fun deleteDocument(documentId: String): Boolean {
        return api.deleteDocument(documentId).count > 0
    }

    fun getEnPdf(documentId: String, file: File) {
        TODO()
    }

    fun getSlPdf(documentId: String, file: File) {
        TODO()
    }

    fun getDePdf(documentId: String, file: File) {
        TODO()
    }

    fun sendEmail(documentId: String, recipients: List<String>, subject: String, message: String) {
        TODO()
    }

    /*
     * COUNTRIES
     */

    fun getCountries(): List<Country> {
        return api.getCountries().toList()
    }

    /*
     * CURRENCIES
     */

    fun getCurrencies(): List<Currency> {
        return api.getCurrencies().toList()
    }

    /*
     * CLIENTS
     */
    
    fun getClients(organizationId: String, query: String? = null): List<Client> {
        return if (query == null)
            api.getClients(organizationId).toList()
        else
            api.searchClients(organizationId, query).toList()
    }
    
    fun getClient(clientId: String): Client {
        return api.getClient(clientId)
    }
    
    fun createClient(organizationId: String, client: Client): Client {
        return api.createClient(organizationId, client)
    }
    
    fun updateClient(organizationId: String, client: Client): Client {
        return api.updateClient(organizationId, client)
    }
    
    fun deleteClient(clientId: String): Boolean {
        return api.deleteClient(clientId).count > 0
    }

    /*
     * COMPANIES
     */

    fun getCompanies(query: String? = null): List<Company> {
        return if (query == null)
            api.getCompanies().toList()
        else
            api.searchCompanies(query).toList()
    }

    /*
     * ITEMS
     */

    fun getItems(organizationId: String, query: String? = null): List<Item> {
        return if (query == null)
            api.getItems(organizationId).toList()
        else
            api.searchItems(organizationId, query).toList()
    }
    
    fun getItem(itemId: String): Item {
        TODO()
    }

    fun createItem(organizationId: String, item: Item): Item {
        return api.createItem(organizationId, item)
    }

    fun updateItem(organizationId: String, item: Item): Item {
        return api.updateItem(organizationId, item)
    }

    fun deleteItem(itemId: String): Boolean {
        return api.deleteItem(itemId).count > 0
    }

    /*
     * PAYMENTS
     */

    fun getPayments(organizationId: String): List<Payment> {
        return api.getPayments(organizationId).toList()
    }
    
    fun getPaymentsForDocument(documentId: String): List<Payment> {
        return api.getPaymentsForDocument(documentId).toList()
    }
    
    fun createPayment(documentId: String, payment: Payment): Payment {
        return api.createPayment(documentId, payment)
    }
    
    fun updatePayment(paymentId: String, payment: Payment): Payment {
        return api.updatePayment(paymentId, payment)
    }
    
    fun deletePayment(paymentId: String): Boolean {
        return api.deletePayment(paymentId).count > 0
    }

    /*
     * RECURRENCES
     */
    
    fun getRecurrences(organizationId: String): List<Recurrence> {
        return api.getRecurrences(organizationId).toList()
    }

    fun getRecurrencesForDocument(documentId: String): List<Recurrence> {
        return api.getRecurrencesForDocument(documentId).toList()
    }

    fun createRecurrence(documentId: String, recurrence: Recurrence): Recurrence {
        return api.createRecurrence(documentId, recurrence)
    }

    fun updateRecurrence(recurrenceId: String, recurrence: Recurrence): Recurrence {
        TODO()
    }

    fun deleteRecurrence(recurrenceId: String): Boolean {
        return api.deleteRecurrence(recurrenceId).count > 0
    }

    /*
     * TAXES
     */

    fun getTaxes(organizationId: String): List<Tax> {
        return api.getTaxes(organizationId).toList()
    }

    fun createTax(organizationId: String, tax: Tax): Tax {
        return api.createTax(organizationId, tax)
    }

    fun updateTax(taxId: String, tax: Tax): Tax {
        return api.updateTax(taxId, tax)
    }

    fun deleteTax(taxId: String): DeleteResponse {
        return api.deleteTax(taxId)
    }

    fun addTaxRate(taxId: String, taxRate: TaxRate): TaxRate {
        return api.addTaxRate(taxId, taxRate)
    }

}
