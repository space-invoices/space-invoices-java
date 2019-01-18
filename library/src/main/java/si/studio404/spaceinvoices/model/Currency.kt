package si.studio404.spaceinvoices.model

import com.google.gson.annotations.SerializedName

data class Currency(
    @SerializedName("id")       val id: String,
    @SerializedName("name")     val name: String,
    @SerializedName("symbol")   val symbol: String,
    @SerializedName("type")     val type: String
)
