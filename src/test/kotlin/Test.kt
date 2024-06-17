import `fun`.fantasea.tracemoe.TraceMoeClient
import `fun`.fantasea.tracemoe.api.SearchByImageUrl
import org.junit.jupiter.api.Test

class Test {
    @Test
    fun test() {
        val client = TraceMoeClient(null)
        val api = SearchByImageUrl("https://images.plurk.com/32B15UXxymfSMwKGTObY5e.jpg")
        val response = client.execute(api)
        println(response.toString())
    }
}
