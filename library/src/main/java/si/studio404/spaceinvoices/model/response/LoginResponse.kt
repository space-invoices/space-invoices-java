package si.studio404.spaceinvoices.model.response

import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @SerializedName("userId")   val accountId: String,
    @SerializedName("id")       val token: String
)
