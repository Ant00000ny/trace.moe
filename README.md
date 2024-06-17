## trace.moe

### What is this?

An kotlin impl of trace.moe api.

### How to use it?

Add it to project dependency:

```xml

<dependency>
    <groupId>fun.fantasea</groupId>
    <artifactId>trace.moe</artifactId>
    <version>1.0</version>
</dependency>
```

```kotlin
val client = TraceMoeClient() // add token as param if you have one
// create an api instance and pass params
val api = SearchByImageUrl("https://images.plurk.com/32B15UXxymfSMwKGTObY5e.jpg")
// execute this api by client
val response = client.execute(api)

println(response.toString())
```
