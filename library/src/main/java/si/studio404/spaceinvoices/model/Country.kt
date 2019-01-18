package si.studio404.spaceinvoices.model

import com.google.gson.annotations.SerializedName

//@Builder
data class Country(
    @SerializedName("name")         val name: String,
    @SerializedName("alpha2Code")   val alpha2Code: String,
    @SerializedName("alpha3Code")   val alpha3Code: String,
    @SerializedName("currency")     val currency: String,
    @SerializedName("nativeName")   val nativeName: String,
    @SerializedName("numericCode")  val numericCode: String,
    @SerializedName("taxes")        val taxes: List<Tax>,
    @SerializedName("translations") val translations: Translations
) {

    //@Builder
    data class Tax(
        @SerializedName("abbreviation")     val abbreviation: String,
        @SerializedName("classification")   val classification: String,
        @SerializedName("name")             val name: String,
        @SerializedName("rate")             val rate: String
    )

    //@Builder
    data class Translations(
        @SerializedName("br") val br: String,
        @SerializedName("de") val de: String,
        @SerializedName("es") val es: String,
        @SerializedName("fa") val fa: String,
        @SerializedName("fr") val fr: String,
        @SerializedName("hr") val hr: String,
        @SerializedName("it") val it: String,
        @SerializedName("ja") val ja: String,
        @SerializedName("nl") val nl: String,
        @SerializedName("pt") val pt: String
    )

}
