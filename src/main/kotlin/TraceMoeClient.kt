import okhttp3.OkHttpClient

class TraceMoeClient(
    val accessToken: String? = null,
) {
    val httpClient = OkHttpClient()
}
