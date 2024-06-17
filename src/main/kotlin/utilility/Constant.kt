package utilility

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import okhttp3.HttpUrl.Companion.toHttpUrl
import okhttp3.OkHttpClient

internal object Constant {
    val BASE_SEARCH_URL = "https://api.trace.moe/search".toHttpUrl()
    val httpClient = OkHttpClient.Builder()
        .followRedirects(true)
        .build()
    val objectMapper = ObjectMapper()
        .registerKotlinModule()
}
