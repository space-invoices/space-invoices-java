package si.studio404.spaceinvoices.rest

import com.google.gson.Gson
import okhttp3.MediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody
import si.studio404.spaceinvoices.model.response.ErrorResponse
import si.studio404.spaceinvoices.util.SpaceInvoicesException
import si.studio404.spaceinvoices.util.addHeaders
import si.studio404.spaceinvoices.util.newRequest
import java.util.concurrent.TimeUnit

internal class SpaceRest(
    httpClient: OkHttpClient?
) {

    private val gson = Gson()
    private val client = httpClient ?: defaultHttpClient()
    private val jsonContentType = MediaType.parse("application/json; charset=utf-8")

    /*
     * REST
     */

    internal inline fun <reified T> get(
        url: String,
        headers: Map<String, String>
    ): T {
        return execute(
            newRequest(url) {
                addHeaders(headers)
                get()
            }
        )
    }

    internal inline fun <reified T> post(
        url: String,
        headers: Map<String, String> = emptyMap(),
        body: Any
    ): T {
        val json = gson.toJson(body)
        println("SENT [POST]: $json")
        return execute(
            newRequest(url) {
                addHeaders(headers)
                post(RequestBody.create(jsonContentType, json))
            }
        )
    }

    internal inline fun <reified T> put(
        url: String,
        headers: Map<String, String> = emptyMap(),
        body: Any
    ): T {
        val json = gson.toJson(body)
        println("SENT [PUT]: $json")
        return execute(
            newRequest(url) {
                addHeaders(headers)
                put(RequestBody.create(jsonContentType, json))
            }
        )
    }

    internal inline fun <reified T> delete(
        url: String,
        headers: Map<String, String> = emptyMap()
    ): T {
        return execute(
            newRequest(url) {
                addHeaders(headers)
                delete()
            }
        )
    }

    /*
     * OTHER
     */

    private inline fun <reified T> execute(request: Request): T {
        client.newCall(request).execute().use { response ->
            val json = response.body()?.string()
            println("RECEIVED: $json")
            if (response.isSuccessful) {
                return gson.fromJson<T>(json, T::class.java)
            } else {
                val error = gson.fromJson<ErrorResponse>(json, ErrorResponse::class.java).error
                throw SpaceInvoicesException("[${error.name}] ${error.message} - ${response.code()} ${error.status}")
            }
        }
    }

    private fun defaultHttpClient() = OkHttpClient.Builder().apply {
        connectTimeout(10, TimeUnit.SECONDS)
        writeTimeout(10, TimeUnit.SECONDS)
        readTimeout(15, TimeUnit.SECONDS)
    }.build()

}
