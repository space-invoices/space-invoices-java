package si.studio404.spaceinvoices.model

import com.google.gson.annotations.SerializedName

//@Builder
data class Tax(
    @SerializedName("id")               val taxId: String,
    @SerializedName("name")             val name: String,
    @SerializedName("abbreviation")     val abbreviation: String,
    @SerializedName("_taxRates")        val taxRates: List<TaxRate>,
    @SerializedName("compound")         val compound: Boolean,
    @SerializedName("recoverable")      val recoverable: Boolean
)
