package api

import TraceMoeClient
import model.TraceMoeResponse
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import utilility.Constant
import utilility.Function.convertTo

/**
 * curl --data-binary "@demo.jpg" https://api.trace.moe/search
 */
class SearchByImageUpload(
    private val imageBytes: ByteArray,
    private val cutBorders: Boolean = false,
) : Api {
    override fun executeBy(client: TraceMoeClient): TraceMoeResponse {
        val requestBody = imageBytes.toRequestBody("application/octet-stream".toMediaTypeOrNull())

        val url = Constant.BASE_SEARCH_URL.newBuilder()
            .apply {
                if (cutBorders) addQueryParameter("cutBorders", null)
            }
            .build()

        val request = Request.Builder()
            .url(url)
            .post(requestBody)
            .build()

        val traceMoeResponse = Constant.httpClient.newCall(request)
            .execute()
            .body
            .use { it.string() }
            .convertTo<TraceMoeResponse>()

        return traceMoeResponse
    }
}
