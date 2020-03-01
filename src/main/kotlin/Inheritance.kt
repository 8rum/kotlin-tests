fun main() {
    open class Type(val name: String)
    class Custom(val id: Long, val msg: String, name: String) : Type(name) {
        init {
            if (msg == "") throw Exception("Bad parameters: $this")
        }
    }

    println(Custom(1, "one", "number"))
}