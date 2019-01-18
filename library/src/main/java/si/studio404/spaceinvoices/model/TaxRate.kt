package si.studio404.spaceinvoices.model

import com.google.gson.annotations.SerializedName

data class TaxRate(
    @SerializedName("id")           val taxRateId: String,
    @SerializedName("dateValidFrom")val dateValidFrom: String,
    @SerializedName("rate")         val rate: Int
)
