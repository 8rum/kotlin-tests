fun main() {
    data class Itens(val num: Long, val text: String)
    data class MyClass(val id: Long, val itens: List<Itens>)

    val numbers = listOf(
        MyClass(1, listOf(Itens(11, "one"))),
        MyClass(2, listOf(Itens(21, "two"))),
        MyClass(2, listOf(Itens(22, "two, two"))),
        MyClass(3, listOf(Itens(31, "three"), Itens(32, "three, three")))
    )

    println(numbers.groupBy { it.id })
    println()

    println(
        numbers.groupBy(
            keySelector = { it.id },
            valueTransform = { it.itens }
        ).map {
            MyClass(
                it.key,
                it.value.flatten()
            )
        }
    )
}