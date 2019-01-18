package si.studio404.spaceinvoices.sample

import si.studio404.spaceinvoices.SpaceInvoices

fun main(args: Array<String>) {

    // this call returns token / LAUNCH_CODE
    val token = TokenProvider.getToken()
    // this call returns accountId - received on login
    val accountId = TokenProvider.getAccountId()

    // set testing to true to run on test backend
    val si = SpaceInvoices(token, testing = true)
    println("token = ${si.token}")

    // get all organizations
    val organizations = si.getOrganizations(accountId)
    println("organizations = ${organizations.joinToString()}")

    // use first organization for this sample
    val organizationId = organizations.first().organizationId

    val documents = si.getDocuments(organizationId)
    println("documents = ${documents.joinToString()}")

    val document = si.getDocument(documents.first().documentId)
    println("document = $document")

//    val newDocument = si.createDocument(organizationId, Document())
//    println("newDocument = $newDocument")
//
//    val updatedDocument = si.updateDocument(organizationId, newDocument.copy(note = "updated"))
//    println("updatedDocument = $updatedDocument")
//
//    val deletedDocument = si.deleteDocument(updatedDocument.documentId)
//    println("deletedDocument = $deletedDocument")

    // TODO: getEnPdf

    // TODO: getSlPdf

    // TODO: getDePdf

    // TODO: sendEmail

}