package si.studio404.spaceinvoices.model

import com.google.gson.annotations.SerializedName

//@Builder
data class Account(
    @SerializedName("id")       val accountId: String = "",
    @SerializedName("email")    val email: String
)
