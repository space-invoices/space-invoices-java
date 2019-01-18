package si.studio404.spaceinvoices.model

import com.google.gson.annotations.SerializedName

//@Builder
data class Organization(
    @SerializedName("id")           val organizationId: String = "",
    @SerializedName("name")         val name: String,
    @SerializedName("address")      val address: String? = null,
    @SerializedName("city")         val city: String? = null,
    @SerializedName("zip")          val zip: String? = null,
    @SerializedName("country")      val country: String? = null,
    @SerializedName("IBAN")         val iban: String? = null,
    @SerializedName("bank")         val bank: String? = null,
    @SerializedName("_defaults")    val defaults: List<Default> = emptyList(),
    @SerializedName("locale")       val locale: String? = null,
    @SerializedName("active")       val active: Boolean? = null,
    @SerializedName("supportPin")   val supportPin: String? = null,
    @SerializedName("brand")        val brand: String? = null
) {

    data class Default(
        @SerializedName("name")     val name: String,
        @SerializedName("value")    val value: String
    )

}
