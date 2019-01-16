package si.studio404.spaceinvoices.model.response
import com.google.gson.annotations.SerializedName


data class Organization(
    @SerializedName("id")           val organizationId: String,
    @SerializedName("name")         val name: String,
    @SerializedName("address")      val address: String,
    @SerializedName("city")         val city: String,
    @SerializedName("zip")          val zip: String,
    @SerializedName("country")      val country: String,
    @SerializedName("IBAN")         val iban: String,
    @SerializedName("bank")         val bank: String,
//    @SerializedName("_defaults")    val defaults: List<Default>,
    @SerializedName("locale")       val locale: String,
    @SerializedName("active")       val active: Boolean,
    @SerializedName("supportPin")   val supportPin: String,
    @SerializedName("brand")        val brand: String
) {
    data class Default(
        @SerializedName("name")     val name: String,
        @SerializedName("value")    val value: String
    )
}
