import `fun`.fantasea.tracemoe.TraceMoeClient
import `fun`.fantasea.tracemoe.api.SearchByImageUrl
import `fun`.fantasea.tracemoe.utilility.Constant
import org.junit.jupiter.api.Test

class Test {
    @Test
    fun test() {
        val client = TraceMoeClient(null)
        val response = client.execute(SearchByImageUrl("https://images.plurk.com/32B15UXxymfSMwKGTObY5e.jpg"))
        println(Constant.objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(response))
    }
}
