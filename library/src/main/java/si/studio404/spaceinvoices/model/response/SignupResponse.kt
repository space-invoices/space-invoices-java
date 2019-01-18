package si.studio404.spaceinvoices.model.response

import com.google.gson.annotations.SerializedName

data class SignupResponse(
    @SerializedName("id")       val accountId: String,
    @SerializedName("email")    val email: String
)
