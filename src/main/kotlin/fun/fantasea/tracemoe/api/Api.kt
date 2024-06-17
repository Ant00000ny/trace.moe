package `fun`.fantasea.tracemoe.api

import `fun`.fantasea.tracemoe.TraceMoeClient

internal interface Api<R> {
    fun executeBy(client: TraceMoeClient): R
}
