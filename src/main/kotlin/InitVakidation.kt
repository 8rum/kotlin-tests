fun main() {
    data class Custom(val id: Long, val msg: String) {
        init {
            if (msg == "") throw Exception("Bad parameters: $this")
        }
    }

    println(Custom(1, "one"))
    println(Custom(2, "two"))
    println(Custom(0, ""))
}