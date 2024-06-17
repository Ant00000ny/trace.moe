package `fun`.fantasea.tracemoe.api

import `fun`.fantasea.tracemoe.TraceMoeClient
import `fun`.fantasea.tracemoe.exception.ErrorException
import `fun`.fantasea.tracemoe.model.TraceMoeResponse
import `fun`.fantasea.tracemoe.utilility.Constant
import `fun`.fantasea.tracemoe.utilility.Function.convertTo
import okhttp3.HttpUrl.Companion.toHttpUrlOrNull
import okhttp3.Request

/**
 * curl "https://api.trace.moe/search?url=https://images.plurk.com/32B15UXxymfSMwKGTObY5e.jpg"
 */
class SearchByImageUrl(
    private val imageUrl: String,
    private val cutBorders: Boolean = false,
    private val anilistID: Int? = null,
) : TraceMoeApi<TraceMoeResponse> {
    override fun executeBy(client: TraceMoeClient): TraceMoeResponse {
        if (imageUrl.toHttpUrlOrNull() == null) {
            throw ErrorException("imageUrl is not a valid http url")
        }

        val url = Constant.BASE_SEARCH_URL.newBuilder()
            .apply {
                addQueryParameter("url", imageUrl)
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
