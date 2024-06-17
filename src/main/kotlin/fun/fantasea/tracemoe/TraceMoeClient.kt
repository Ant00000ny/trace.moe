package `fun`.fantasea.tracemoe

import `fun`.fantasea.tracemoe.api.TraceMoeApi
import okhttp3.OkHttpClient

class TraceMoeClient(
    val accessToken: String? = null,
) {
    val httpClient = OkHttpClient()

    fun <R> execute(api: TraceMoeApi<R>): R {
        return api.executeBy(this)
    }
}
