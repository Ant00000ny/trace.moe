package api

import TraceMoeClient
import model.TraceMoeResponse
import okhttp3.HttpUrl
import okhttp3.Request
import utilility.Constant
import utilility.Function.convertTo

/**
 * curl "https://api.trace.moe/search?url=https://images.plurk.com/32B15UXxymfSMwKGTObY5e.jpg"
 */
class SearchByImageUrl(
    private val imageUrl: HttpUrl,
) : Api {
    private val path = "search"

    override fun executeBy(client: TraceMoeClient): TraceMoeResponse {
        val url = Constant.BASE_URL.newBuilder()
            .addPathSegments(path)
            .addQueryParameter("url", imageUrl.toString())
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
