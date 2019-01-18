package si.studio404.spaceinvoices.model

import com.google.gson.annotations.SerializedName

//@Builder
data class Company(
    @SerializedName("id")               val companyId: String,
    @SerializedName("name")             val name: String,
    @SerializedName("companyNumber")    val companyNumber: String,
    @SerializedName("address")          val address: String,
    @SerializedName("city")             val city: String,
    @SerializedName("country")          val country: String,
    @SerializedName("taxNumber")        val taxNumber: String,
    @SerializedName("taxSubject")       val taxSubject: Boolean,
    @SerializedName("zip")              val zip: String
)
