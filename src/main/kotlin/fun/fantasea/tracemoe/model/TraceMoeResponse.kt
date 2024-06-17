package `fun`.fantasea.tracemoe.model

/**
 * ```json
 * {
 *   "frameCount": 745506,
 *   "error": "",
 *   "result": [
 *     {
 *       "anilist": 99939,
 *       "filename": "Nekopara - OVA (BD 1280x720 x264 AAC).mp4",
 *       "episode": null,
 *       "from": 97.75,
 *       "to": 98.92,
 *       "similarity": 0.9440424588727485,
 *       "video": "https://api.trace.moe/video/99939/Nekopara%20-%20OVA%20(BD%201280x720%20x264%20AAC).mp4?t=98.335&now=1653892514&token=xxxxxxxxxxxxxx",
 *       "image": "https://api.trace.moe/image/99939/Nekopara%20-%20OVA%20(BD%201280x720%20x264%20AAC).mp4.jpg?t=98.335&now=1653892514&token=xxxxxxxxxxxxxx"
 *     }
 *   ]
 * }
 *
 * ```
 */
data class TraceMoeResponse(
    val frameCount: Int,
    val error: String,
    val result: List<TraceMoeResult>,
)

data class TraceMoeResult(
    val anilist: Int,
    val filename: String,
    val episode: String?,
    val from: Double,
    val to: Double,
    val similarity: Double,
    val video: String,
    val image: String,
)
