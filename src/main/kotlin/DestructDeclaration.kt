fun main() {
    data class ToDestruct(val id: Long, val msg: String)

    val toDestruct = ToDestruct(1, "one")
    fun testFun(id: Long, msg: String) =
        println("id: $id - msg $msg")

    val (id, msg) = toDestruct
    testFun(id, msg)
}