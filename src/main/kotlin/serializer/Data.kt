//@file:UseSerializers(LocalDateTimeSerializer::class)
@file:ContextualSerialization(LocalDateTime::class)
package serializer

import kotlinx.serialization.ContextualSerialization
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers
import java.time.LocalDateTime

@Serializable
data class Data(
    val a: Int,
    val b: String = "42",
    val c: String? = null,
//    @Serializable(with = LocalDateTimeSerializer::class)
    val d: LocalDateTime
)
