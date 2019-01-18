package si.studio404.spaceinvoices.model

import com.google.gson.annotations.SerializedName

//@Builder
data class Client(
    @SerializedName("id")               val clientId: String,
    @SerializedName("organizationId")   val organizationId: String,
    @SerializedName("name")             val name: String,
    @SerializedName("email")            val email: String,
    @SerializedName("phone")            val phone: String,
    @SerializedName("address")          val address: String,
    @SerializedName("city")             val city: String,
    @SerializedName("zip")              val zip: String,
    @SerializedName("country")          val country: String,
    @SerializedName("contact")          val contact: String,
    @SerializedName("note")             val note: String
)
