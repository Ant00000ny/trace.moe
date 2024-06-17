package api

import TraceMoeClient
import model.TraceMoeResponse

internal interface Api {
    fun executeBy(client: TraceMoeClient): TraceMoeResponse
}
