package si.studio404.spaceinvoices.model

import com.google.gson.annotations.SerializedName

//@Builder
data class Recurrence(
    @SerializedName("id")               val recurrenceId: String = "",
    @SerializedName("documentId")       val documentId: String,
    @SerializedName("organizationId")   val organizationId: String,
    @SerializedName("amount")           val amount: Int,
    @SerializedName("date")             val date: String,
    @SerializedName("type")             val type: String
)
