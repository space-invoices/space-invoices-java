package si.studio404.spaceinvoices.util

import okhttp3.Request

fun newRequest(url: String, op: Request.Builder.() -> Unit): Request {
    return Request.Builder()
        .url(url)
        .apply(op)
        .build()
}

fun Request.Builder.addHeaders(headers: Map<String, String>) = apply {
    headers.forEach { name, value -> addHeader(name, value) }
}

//fun MultipartBody.Builder.addFormDataParts(parts: Map<String, String>) = apply {
//    parts.forEach { name, value -> addFormDataPart(name, value) }
//}
