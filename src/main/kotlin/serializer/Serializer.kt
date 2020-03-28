package serializer

import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonConfiguration
import kotlinx.serialization.modules.serializersModuleOf
import java.time.LocalDateTime

fun main() {
    // Json also has .Default configuration which provides more reasonable settings,
    // but is subject to change in future versions
    val json = Json(
        JsonConfiguration.Stable.copy(
            ignoreUnknownKeys = true,
            isLenient = true
        ),
        context = serializersModuleOf(mapOf(LocalDateTime::class to LocalDateTimeSerializer))
    )
    // serializing objects
    val jsonData = json.stringify(Data.serializer(), Data(a = 42, d = LocalDateTime.now().plusDays(1)))
//    // serializing lists
//    val jsonList = json.stringify(Data.serializer().list, listOf(Data(42)))
//    println(jsonData) // {"a": 42, "b": "42"}
//    println(jsonList) // [{"a": 42, "b": "42"}]

    // parsing data back
    val obj = json.parse(
        Data.serializer(),
        """{"a":42, "d": "26/11/1986 07:16:45.186", "x":10}"""
    ) // b is optional since it has default value
    println(obj) // Data(a=42, b="42")
}
