package utilility

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import okhttp3.HttpUrl.Companion.toHttpUrl
import okhttp3.OkHttpClient

internal object Constant {
    val BASE_URL = "https://api.trace.moe".toHttpUrl()
    val httpClient = OkHttpClient.Builder()
        .followRedirects(true)
        .build()
    val objectMapper = ObjectMapper()
        .registerKotlinModule()
}
