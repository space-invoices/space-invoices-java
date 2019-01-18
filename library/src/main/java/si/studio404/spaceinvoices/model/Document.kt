package si.studio404.spaceinvoices.model

import com.google.gson.annotations.SerializedName
import java.util.*

//@Builder
data class Document(
    @SerializedName("id")                       val documentId: String = "",
    @SerializedName("organizationId")           val organizationId: String,
    @SerializedName("clientId")                 val clientId: String,
    @SerializedName("_comments")                val comments: List<Any>,
    @SerializedName("_documentClient")          val documentClient: Client,
    @SerializedName("_documentIssuer")          val documentIssuer: Issuer,
    @SerializedName("_documentItems")           val documentItems: List<Item>,
    @SerializedName("_documentReverseTaxes")    val documentReverseTaxes: List<Any>,
    @SerializedName("_documentTaxes")           val documentTaxes: List<Any>,
    @SerializedName("canceled")                 val canceled: Boolean,
    @SerializedName("createdAt")                val createdAt: String,
    @SerializedName("currencyId")               val currencyId: String,
    @SerializedName("date")                     val date: Date,
    @SerializedName("dateDue")                  val dateDue: String,
    @SerializedName("dateService")              val dateService: String,
    @SerializedName("draft")                    val draft: Boolean,
    @SerializedName("footer")                   val footer: String,
    @SerializedName("note")                     val note: String,
    @SerializedName("number")                   val number: String,
    @SerializedName("paidInFull")               val paidInFull: Boolean,
    @SerializedName("sentEmail")                val sentEmail: Boolean,
    @SerializedName("signature")                val signature: String,
    @SerializedName("total")                    val total: Int,
    @SerializedName("totalDiscount")            val totalDiscount: Int,
    @SerializedName("totalPaid")                val totalPaid: Int,
    @SerializedName("totalWithTax")             val totalWithTax: Int,
    @SerializedName("type")                     val type: String
) {

    //@Builder
    data class Issuer(
        @SerializedName("IBAN")                 val iban: String,
        @SerializedName("address")              val address: String,
        @SerializedName("bank")                 val bank: String,
        @SerializedName("city")                 val city: String,
        @SerializedName("country")              val country: String,
        @SerializedName("name")                 val name: String,
        @SerializedName("zip")                  val zip: String
    )

    //@Builder
    data class Item(
        @SerializedName("_documentItemTaxes")   val documentItemTaxes: List<Tax>,
        @SerializedName("discount")             val discount: Int,
        @SerializedName("id")                   val id: String,
        @SerializedName("name")                 val name: String,
        @SerializedName("price")                val price: Int,
        @SerializedName("quantity")             val quantity: Int,
        @SerializedName("total")                val total: Int,
        @SerializedName("totalDiscount")        val totalDiscount: Int,
        @SerializedName("totalWithTax")         val totalWithTax: Int,
        @SerializedName("unit")                 val unit: String
    ) {

        //@Builder
        data class Tax(
            @SerializedName("id")               val id: String,
            @SerializedName("name")             val name: String,
            @SerializedName("rate")             val rate: Int,
            @SerializedName("compound")         val compound: Boolean,
            @SerializedName("recoverable")      val recoverable: Boolean,
            @SerializedName("reverseCharged")   val reverseCharged: Boolean
        )

    }

    data class Client(
        @SerializedName("name")                 val name: String,
        @SerializedName("city")                 val city: String,
        @SerializedName("country")              val country: String
    )

}
