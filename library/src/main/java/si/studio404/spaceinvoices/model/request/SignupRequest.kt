package si.studio404.spaceinvoices.model.request

import com.google.gson.annotations.SerializedName

data class SignupRequest(
    @SerializedName("email")    val email: String,
    @SerializedName("password") val password: String
)