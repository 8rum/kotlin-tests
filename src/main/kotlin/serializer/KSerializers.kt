package serializer

import kotlinx.serialization.*
import java.math.BigDecimal
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@Serializer(forClass = LocalDateTime::class)
object LocalDateTimeSerializer : KSerializer<LocalDateTime> {
    private val format = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss.SSS")

    override val descriptor: SerialDescriptor =
        PrimitiveDescriptor("LocalDateTime", PrimitiveKind.STRING)

    override fun serialize(encoder: Encoder, obj: LocalDateTime) {
        encoder.encodeString(format.format(obj))
    }

    override fun deserialize(decoder: Decoder): LocalDateTime {
        return LocalDateTime.parse(decoder.decodeString(), format)
    }
}

@Serializer(forClass = BigDecimal::class)
object BigDecimalSerializer: KSerializer<BigDecimal> {
    override val descriptor: SerialDescriptor =
        PrimitiveDescriptor("BigDecimal", PrimitiveKind.STRING)

    override fun serialize(output: Encoder, obj: BigDecimal) {
        output.encodeString(obj.toString())
    }

    override fun deserialize(input: Decoder): BigDecimal {
        return BigDecimal(input.decodeString())
    }
}