package serializer

import kotlinx.serialization.builtins.list
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonConfiguration
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.int
import kotlinx.serialization.modules.serializersModuleOf
import java.math.BigDecimal
import java.time.LocalDateTime

fun main() {
    // Json also has .Default configuration which provides more reasonable settings,
    // but is subject to change in future versions
    val json = Json(
        JsonConfiguration.Stable.copy(
            ignoreUnknownKeys = true,
            isLenient = true
        ),
        context = serializersModuleOf(
            mapOf(
                LocalDateTime::class to LocalDateTimeSerializer,
                BigDecimal::class to BigDecimalSerializer
            )
        )
    )
    // serializing objects
    val jsonData = json.stringify(
        Data.serializer(),
        Data(
            a = 42,
            d = LocalDateTime.now().plusDays(1),
            e = BigDecimal(123456789.987654321)
        )
    )
//    // serializing lists
//    val jsonList = json.stringify(Data.serializer().list, listOf(Data(42)))
    println(jsonData) // {"a": 42, "b": "42"}
//    println(jsonList) // [{"a": 42, "b": "42"}]

    // parsing data back
    val obj = json.parse(
        Data.serializer(),
        """{"a":42, "d": "26/11/1986 07:16:45.186", "e":123456789.987654321, "x":10}"""
    ) // b is optional since it has default value
    println(obj) // Data(a=42, b="42")

    // parsing data back
    val objJson = json.parse(
        JsonObject.serializer().list,
        """[{"a":42, "d": "26/11/1986 07:16:45.186", "x":{"x1": 1, "x2":"2"}}]"""
    )
    println("x1: " + objJson[0]["d"].toString())
    println("x1: " + objJson[0]["x"]?.jsonObject!!["x1"])
    println("x2: " + objJson[0]["x"]?.jsonObject!!["x2"]?.int)
    println("x3: " + objJson[0]["x"]?.jsonObject!!["x3"])
//    println("xX: " + objJson[0]["x"]?.jsonObject!!["x3"]?.jsonObject!!["x"]) // KotlinNullPointerException
}
