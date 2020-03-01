import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun main() {
    val ini = System.currentTimeMillis()
    runBlocking {
        // this: CoroutineScope
        val x = async {
            println("Coroutine X started")
            // launch a new coroutine in the scope of runBlocking
            delay(1000L)
            "OK"
        }
        val y = async {
            println("Coroutine Y started")
            // launch a new coroutine in the scope of runBlocking
            delay(1000L)
            "OK"
        }
        println("X returned: ${x.await()} - Y returned: ${y.await()}")
    }
    println("${System.currentTimeMillis() - ini}ms to run")
}