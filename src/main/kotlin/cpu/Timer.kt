package cpu

import java.util.concurrent.atomic.AtomicInteger
import kotlinx.coroutines.*

class Timer {


    private val value = AtomicInteger(0)
    private val scope = CoroutineScope(Dispatchers.Default)
    private var job: Job? = null
    // Launch thread/coroutine timing every 16 miliseconds
    fun start(){
        job = scope.launch{
            while (isActive){
                delay(16)
                value.updateAndGet{ if (it > 0) it - 1 else 0}
            }
        }
    }

    // Stop Timing
    fun stop(){
        job?.cancel()
    }


    // public getter and setter
    fun set(v: Int) = value.set(v and 0xFF)
    fun get(): Int = value.get()
}