package si.studio404.spaceinvoices.rest

import com.google.gson.Gson
import okhttp3.*
import si.studio404.spaceinvoices.util.addHeaders
import java.util.concurrent.TimeUnit
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.logging.HttpLoggingInterceptor.Level
import si.studio404.spaceinvoices.model.response.ErrorResponse
import si.studio404.spaceinvoices.util.SpaceInvoicesException

internal abstract class SpaceRest(
    private val client: OkHttpClient = DEFAULT_CLIENT
) {

    private val gson = Gson()
    private val jsonMime = MediaType.parse("application/json; charset=utf-8")

    companion object {
        internal val DEFAULT_CLIENT
            get() = OkHttpClient.Builder().apply {
                connectTimeout(10, TimeUnit.SECONDS)
                writeTimeout(10, TimeUnit.SECONDS)
                readTimeout(15, TimeUnit.SECONDS)
                addInterceptor(HttpLoggingInterceptor().apply { level = Level.BASIC })
            }.build()
    }

    internal inline fun <reified T> get(
        url: String,
        headers: Map<String, String>
    ): T {
        return execute(
            Request.Builder()
                .url(url)
                .addHeaders(headers)
                .get()
                .build()
        )
    }

    internal inline fun <reified T> post(
        url: String,
        headers: Map<String, String> = emptyMap(),
        body: Any
    ): T {
        return execute(
            Request.Builder()
                .url(url)
                .addHeaders(headers)
                .post(RequestBody.create(jsonMime, gson.toJson(body)))
                .build()
        )
    }

    private inline fun <reified T> execute(request: Request): T {
        client.newCall(request).execute().use { response ->
            val json = response.body()?.string()
            if (response.isSuccessful) {
                return gson.fromJson<T>(json, T::class.java)
            } else {
                val error = gson.fromJson<ErrorResponse>(json, ErrorResponse::class.java).error
                throw SpaceInvoicesException("[${error.name}] ${error.message} - ${response.code()} ${error.status}")
            }
        }
    }

}
