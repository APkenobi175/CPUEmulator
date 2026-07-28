package cpu

// This is the facade

import io.Keyboard
import io.Screen
import java.io.File

class Computer {
    private val screen = Screen()
    private val keyboard = Keyboard()
    private val timer = Timer()
    private val rom = ROM()
    private val cpu = CPU(rom, screen, keyboard, timer)

    fun load(path: String) {
        val bytes = File(path).readBytes()
        println("Loaded ${bytes.size} bytes: " + bytes.joinToString(" ") { "%02x".format(it) })
        rom.load(bytes)
    }

    fun run(){
        cpu.run()
    }

}