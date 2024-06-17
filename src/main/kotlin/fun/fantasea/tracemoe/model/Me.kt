package `fun`.fantasea.tracemoe.model

import `fun`.fantasea.tracemoe.TraceMoeClient
import `fun`.fantasea.tracemoe.api.Api
import `fun`.fantasea.tracemoe.exception.ErrorException
import `fun`.fantasea.tracemoe.utilility.Constant
import `fun`.fantasea.tracemoe.utilility.Function.convertTo
import okhttp3.Request

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

        val me = client
            .httpClient.newCall(request)
            .execute()
            .body
            .use { it.string() }
            .convertTo<Me>()

        return me
    }
}
