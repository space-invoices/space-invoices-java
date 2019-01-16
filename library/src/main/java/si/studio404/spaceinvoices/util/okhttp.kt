package si.studio404.spaceinvoices.util

import okhttp3.MultipartBody
import okhttp3.Request

fun MultipartBody.Builder.addFormDataParts(data: Map<String, String>) = apply {
    data.forEach { name, value -> addFormDataPart(name, value) }
}

fun Request.Builder.addHeaders(headers: Map<String, String>) = apply {
    headers.forEach { name, value -> addHeader(name, value) }
}
