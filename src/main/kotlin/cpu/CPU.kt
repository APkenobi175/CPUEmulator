package cpu

import instructions.SimpleInstructionFactory
import io.Keyboard
import io.Screen

class CPU(
    private val rom: ROM,
    private val screen: Screen,
    private val keyboard: Keyboard,
    private val timer: Timer
) {
    private val registers = ByteStorage(8)
    private val ram = ByteStorage(4096)

    var addressRegister: Int = 0
    var memoryFlag: Boolean = false // false = RAM, true = ROM
    var programCounter: Int = 0

    fun readRegister(index: Int): Int{
        return registers.read(index)
    }

    fun writeRegister(index: Int, value: Int){
        registers.write(index, value)
    }


    fun drawToScreen(value: Int, row: Int, column: Int){
        screen.draw(value, row, column)
    }

    fun readMemory(offset: Int = 0): Int{
        return if (memoryFlag) rom.read(addressRegister + offset)
            else ram.read(addressRegister + offset)


    }

    fun writeMemory(value: Int, offset: Int = 0){
        if (memoryFlag) rom.write(addressRegister + offset, value)
            else ram.write(addressRegister + offset, value)
    }

    fun awaitKeyPress(): Int{
        return keyboard.readByte()
    }

    fun readTimer(): Int = timer.get()
    fun setTimer(v: Int) = timer.set(v)

    private var running = false
    fun halt(){
        running = false
    }


    // Made it internal so I can test it
    internal fun fetch(): Int{
        val high = rom.read(programCounter)
        val low = rom.read(programCounter + 1)
        return (high shl 8) or low
    }

    fun run(){
        val factory = SimpleInstructionFactory()
        timer.start()
        running = true
        try{
            while(running){
                val raw = fetch()
                if (raw == 0x0000) break
                factory.create(raw, this).execute(raw)
                screen.render()
            }
        } catch(e: Exception){
            println("Program Terminated: ${e.message}")
        } finally{
            timer.stop()
        }
    }

}