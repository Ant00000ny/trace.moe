package `fun`.fantasea.tracemoe.utilility

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import okhttp3.HttpUrl.Companion.toHttpUrl

internal object Constant {
    val BASE_SEARCH_URL = "https://api.trace.moe/search".toHttpUrl()
    val BASE_ME_URL = "https://api.trace.moe/me".toHttpUrl()
    val objectMapper = ObjectMapper()
        .registerKotlinModule()
    const val TRACE_MOE_KEY_HEADER = "x-trace-key"
}
