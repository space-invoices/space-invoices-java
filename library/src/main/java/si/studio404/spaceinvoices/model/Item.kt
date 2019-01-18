package si.studio404.spaceinvoices.model

import com.google.gson.annotations.SerializedName

//@Builder
data class Item(
    @SerializedName("id")               val itemId: String = "",
    @SerializedName("name")             val name: String,
    @SerializedName("description")      val description: String,
    @SerializedName("organizationId")   val organizationId: String,
    @SerializedName("price")            val price: Int,
    @SerializedName("taxIds")           val taxIds: List<String>,
    @SerializedName("taxes")            val taxes: List<Tax>,
    @SerializedName("unit")             val unit: String
) {

    //@Builder
    data class Tax(
        @SerializedName("id")           val id: String,
        @SerializedName("name")         val name: String,
        @SerializedName("_taxRates")    val taxRates: List<TaxRate>,
        @SerializedName("abbreviation") val abbreviation: String,
        @SerializedName("compound")     val compound: Boolean,
        @SerializedName("recoverable")  val recoverable: Boolean
    ) {

        data class TaxRate(
            @SerializedName("id")               val id: String,
            @SerializedName("dateValidFrom")    val dateValidFrom: String,
            @SerializedName("rate")             val rate: Int
        )

    }

}
