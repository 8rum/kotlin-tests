package serializer

import kotlinx.serialization.*
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@Serializer(forClass = LocalDateTime::class)
object LocalDateTimeSerializer : KSerializer<LocalDateTime> {
    private val format = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss.SSS")

    override val descriptor: SerialDescriptor =
        PrimitiveDescriptor("WithCustomDefault", PrimitiveKind.STRING)

    override fun serialize(encoder: Encoder, obj: LocalDateTime) {
        encoder.encodeString(format.format(obj))
    }

    override fun deserialize(decoder: Decoder): LocalDateTime {
        return LocalDateTime.parse(decoder.decodeString(), format)
    }
}