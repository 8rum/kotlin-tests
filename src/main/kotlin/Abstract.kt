fun main() {
    abstract class Type {
        abstract val name: String
    }

    data class Custom(val id: Long, val msg: String, override val name: String) : Type() {

        init {
            if (msg == "") throw Exception("Bad parameters: $this")
        }
    }

    println(Custom(1, "one", "number"))
}