package model

import TraceMoeClient
import api.Api
import exception.ErrorException
import okhttp3.Request
import utilility.Constant
import utilility.Function.convertTo

/**
 * ```json
 * {
 *   "id": "127.0.0.1",
 *   "priority": 0,
 *   "concurrency": 1,
 *   "quota": 1000,
 *   "quotaUsed": 43
 * }
 * ```
 */
data class Me(
    val id: String,
    val priority: Int,
    val concurrency: Int,
    val quota: Int,
    val quotaUsed: Int,
) : Api<Me> {
    override fun executeBy(client: TraceMoeClient): Me {
        if (client.accessToken.isNullOrBlank()) {
            throw ErrorException("accessToken is null or blank")
        }

        val url = Constant.BASE_ME_URL

        val request = Request.Builder()
            .get()
            .url(url)
            .header(Constant.TRACE_MOE_KEY_HEADER, client.accessToken)
            .build()

        val me = Constant.httpClient.newCall(request)
            .execute()
            .body
            .use { it.string() }
            .convertTo<Me>()

        return me
    }
}
