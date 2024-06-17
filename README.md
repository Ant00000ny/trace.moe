## trace.moe

### What is this?

An kotlin impl of trace.moe api.

### How to use it?

Add it to project dependency:

```xml

<dependency>
    <groupId>fun.fantasea</groupId>
    <artifactId>trace.moe</artifactId>
    <version>1.1</version>
</dependency>
```

Run code as follows:

```kotlin
val client = TraceMoeClient() // add token as param if you have one
// create an api instance and pass params
val api = SearchByImageUrl("https://images.plurk.com/32B15UXxymfSMwKGTObY5e.jpg")
// execute this api by client
val response = client.execute(api)

println(response.toString()) // toString() will print response as json
```

And you'll get a response of this format:

```json
{
  "frameCount" : 10392694,
  "error" : "",
  "result" : [ {
    "anilist" : 21034,
    "filename" : "[Leopard-Raws] Gochuumon wa Usagi Desu ka 2nd - 01 RAW (KBS 1280x720 x264 AAC).mp4",
    "episode" : "1",
    "from" : 288.58,
    "to" : 292.67,
    "similarity" : 0.99,
    "video" : "https://api.trace.moe/video/21034/%5BLeopard-Raws%5D%20Gochuumon%20wa%20Usagi%20Desu%20ka%202nd%20-%2001%20RAW%20(KBS%201280x720%20x264%20AAC).mp4?t=290.625&now=1718611200&token=LRwAHiuJ6YUKOFozkBw0XV0YfT8",
    "image" : "https://api.trace.moe/image/21034/%5BLeopard-Raws%5D%20Gochuumon%20wa%20Usagi%20Desu%20ka%202nd%20-%2001%20RAW%20(KBS%201280x720%20x264%20AAC).mp4.jpg?t=290.625&now=1718611200&token=Jcs3bpAbJZXHgHc08KfeMfWwQw"
  }, {
    "anilist" : 21034,
    "filename" : "[Ohys-Raws] Gochuumon wa Usagi Desuka 2 - 01 (AT-X 1280x720 x264 AAC).mp4",
    "episode" : "1",
    "from" : 288.75,
    "to" : 292.75,
    "similarity" : 0.9735424868893542,
    "video" : "https://api.trace.moe/video/21034/%5BOhys-Raws%5D%20Gochuumon%20wa%20Usagi%20Desuka%202%20-%2001%20(AT-X%201280x720%20x264%20AAC).mp4?t=290.75&now=1718611200&token=tUk2qQK9bViStIrJUefXN5lAqho",
    "image" : "https://api.trace.moe/image/21034/%5BOhys-Raws%5D%20Gochuumon%20wa%20Usagi%20Desuka%202%20-%2001%20(AT-X%201280x720%20x264%20AAC).mp4.jpg?t=290.75&now=1718611200&token=0nHd9HcQ01ulmstU93Wd4INbE"
  }, 
    ...
  ]
}
```
