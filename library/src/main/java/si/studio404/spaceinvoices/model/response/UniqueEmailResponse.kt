package si.studio404.spaceinvoices.model.response

import com.google.gson.annotations.SerializedName

data class UniqueEmailResponse(
    @SerializedName("isUnique") val isUnique: Boolean
)
