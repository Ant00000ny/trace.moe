package api

import TraceMoeClient

internal interface Api<R> {
    fun executeBy(client: TraceMoeClient): R
}
