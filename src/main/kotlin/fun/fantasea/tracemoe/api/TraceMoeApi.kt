package `fun`.fantasea.tracemoe.api

import `fun`.fantasea.tracemoe.TraceMoeClient

interface TraceMoeApi<R> {
    fun executeBy(client: TraceMoeClient): R
}
