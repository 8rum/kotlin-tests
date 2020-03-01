fun main() {
    data class Type(val name: String)
    data class Custom(val id: Long, val msg: String, val type: Type) {
        constructor (id: Long, msg: String, name: String) : this(id, msg, Type(name))

        init {
            if (msg == "") throw Exception("Bad parameters: $this")
        }
    }

    println(Custom(1, "one", "number"))
}