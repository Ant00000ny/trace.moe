package `fun`.fantasea.tracemoe.api

import `fun`.fantasea.tracemoe.TraceMoeClient
import `fun`.fantasea.tracemoe.model.TraceMoeResponse
import `fun`.fantasea.tracemoe.utilility.Constant
import `fun`.fantasea.tracemoe.utilility.Function.convertTo
import okhttp3.HttpUrl
import okhttp3.Request

/**
 * curl "https://api.trace.moe/search?url=https://images.plurk.com/32B15UXxymfSMwKGTObY5e.jpg"
 */
class SearchByImageUrl(
    private val imageUrl: HttpUrl,
    private val cutBorders: Boolean = false,
    private val anilistID: Int? = null,
) : TraceMoeApi<TraceMoeResponse> {
    override fun executeBy(client: TraceMoeClient): TraceMoeResponse {
        val url = Constant.BASE_SEARCH_URL.newBuilder()
            .apply {
                addQueryParameter("url", imageUrl.toString())
                if (cutBorders) addQueryParameter("cutBorders", null)
                if (anilistID != null) addQueryParameter("anilistID", anilistID.toString())
            }
            .build()

        val request = Request.Builder()
            .url(url)
            .get()
            .build()

        val traceMoeResponse = client.httpClient.newCall(request)
            .execute()
            .body
            .use { it.string() }
            .convertTo<TraceMoeResponse>()

        return traceMoeResponse
    }
}
