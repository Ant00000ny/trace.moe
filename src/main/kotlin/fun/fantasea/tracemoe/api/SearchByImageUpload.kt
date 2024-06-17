package `fun`.fantasea.tracemoe.api

import `fun`.fantasea.tracemoe.TraceMoeClient
import `fun`.fantasea.tracemoe.model.TraceMoeResponse
import `fun`.fantasea.tracemoe.utilility.Constant
import `fun`.fantasea.tracemoe.utilility.Function.convertTo
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody

/**
 * curl --data-binary "@demo.jpg" https://api.trace.moe/search
 */
class SearchByImageUpload(
    private val imageBytes: ByteArray,
    private val cutBorders: Boolean = false,
    private val anilistID: Int? = null,
) : TraceMoeApi<TraceMoeResponse> {
    override fun executeBy(client: TraceMoeClient): TraceMoeResponse {
        val requestBody = imageBytes.toRequestBody("application/octet-stream".toMediaTypeOrNull())

        val url = Constant.BASE_SEARCH_URL.newBuilder()
            .apply {
                if (cutBorders) addQueryParameter("cutBorders", null)
                if (anilistID != null) addQueryParameter("anilistID", anilistID.toString())
            }
            .build()

        val request = Request.Builder()
            .url(url)
            .post(requestBody)
            .build()

        val traceMoeResponse = client.httpClient.newCall(request)
            .execute()
            .body
            .use { it.string() }
            .convertTo<TraceMoeResponse>()

        return traceMoeResponse
    }
}
