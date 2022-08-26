import kotlinx.coroutines.*


fun main() = runBlocking{ //creates a coroutine that blocks the main thread

        //executes in main thread
        println("Main program starts: ${Thread.currentThread().name}")

        //creates a coroutine that runs on a background thread
        GlobalScope.launch {//Thread: T1
            println("Fake work starts: ${Thread.currentThread().name}")//Thread: T1
            mySuspendFunc(1000) //Coroutine is suspended but Thread: T1 is free
            println("Fake work finished: ${Thread.currentThread().name}") //Either T1 or some other thread
        }


        mySuspendFunc(2000) //main thread: wait for coroutine to finish (not a right way to wait)
        println("Main program ends: ${Thread.currentThread().name}") // main thread
}

suspend fun mySuspendFunc(time: Long) {
    //code..
    delay(time)
}

