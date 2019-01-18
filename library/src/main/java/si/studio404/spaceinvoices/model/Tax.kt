package si.studio404.spaceinvoices.model

import com.google.gson.annotations.SerializedName

//@Builder
data class Tax(
    @SerializedName("id")           val id: String = "",
    @SerializedName("name")         val name: String,
    @SerializedName("_taxRates")    val taxRates: List<Rate>,
    @SerializedName("abbreviation") val abbreviation: String,
    @SerializedName("compound")     val compound: Boolean,
    @SerializedName("recoverable")  val recoverable: Boolean
) {

    //@Builder
    data class Rate(
        @SerializedName("dateValidFrom")    val dateValidFrom: String,
        @SerializedName("id")               val id: String,
        @SerializedName("rate")             val rate: Int
    )

}
