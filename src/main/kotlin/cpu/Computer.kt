package cpu

// This is the facade

import java.io.File

class Computer(private val rom: ROM, private val cpu: CPU){ // Evalith feedback : Computer receives collaborators instead of constructing them

    fun load(path: String) {
        val bytes = File(path).readBytes()
        println("Loaded ${bytes.size} bytes: " + bytes.joinToString(" ") { "%02x".format(it) })
        rom.load(bytes)
    }

    fun run(){
        cpu.run()
    }

}