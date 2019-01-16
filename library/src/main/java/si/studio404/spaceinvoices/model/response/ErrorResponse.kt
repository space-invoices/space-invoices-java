package si.studio404.spaceinvoices.model.response

import com.google.gson.annotations.SerializedName

data class ErrorResponse(
    @SerializedName("error")    val error: Error
) {

    data class Error(
        @SerializedName("message")      val message: String,
        @SerializedName("name")         val name: String,
        @SerializedName("statusCode")   val code: Int,
        @SerializedName("code")         val status: String
    )

}
