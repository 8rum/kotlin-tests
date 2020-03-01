import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
    var x: Any? = null
    var y: Any? = null
    val ini = System.currentTimeMillis()

    runBlocking {
        // this: CoroutineScope
        launch {
            // launch a new coroutine in the scope of runBlocking
            delay(1000L)
            x = "X"
        }
        launch {
            // launch a new coroutine in the scope of runBlocking
            delay(1000L)
            y = "Y"
        }
    }
    println(System.currentTimeMillis() - ini)
    println("$x $y")
}