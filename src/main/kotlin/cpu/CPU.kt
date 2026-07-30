package cpu
import instructions.InstructionFactory
import io.Display

import io.InputDevice

class CPU(
    private val rom: ROM,
    private val screen: Display,
    private val keyboard: InputDevice,
    private val timer: Timer,
    private val factory: InstructionFactory // Eva feedback, no instantiating SimpleInstructionFactory
) {
    private val registers = ByteStorage(8)
    private val ram = ByteStorage(4096)

    private var addressRegister: Int = 0
    private var memoryFlag: Boolean = false // false = RAM, true = ROM
    private var programCounter: Int = 0
    private var running = false

    // Address register

    fun setAddress(value: Int){
        addressRegister = value
    }
    fun getAddressRegister(): Int = addressRegister

    // Memory bank

    fun toggleMemoryBank(){
        memoryFlag = !memoryFlag
    }
    fun getMemoryBank(): Boolean{
        return memoryFlag
    }

    // Program counter

    fun getCurrentAddress(): Int{
        return programCounter
    }
    fun jumpTo(address: Int){
        programCounter = address
    }
    fun advanceProgramCounter(amount: Int){
        programCounter += amount
    }

    // Registers

    fun readRegister(index: Int): Int{
        return registers.read(index)
    }

    fun writeRegister(index: Int, value: Int){
        registers.write(index, value)
    }

    // Memory (RAM/ROM)

    fun readMemory(offset: Int = 0): Int{
        return if (memoryFlag) rom.read(addressRegister + offset)
            else ram.read(addressRegister + offset)


    }

    fun writeMemory(value: Int, offset: Int = 0){
        if (memoryFlag) rom.write(addressRegister + offset, value)
            else ram.write(addressRegister + offset, value)
    }

    // Screen

    fun drawToScreen(value: Int, row: Int, column: Int){
        screen.draw(value, row, column)
        screen.render()
    }

    // Keyboard

    fun awaitKeyPress(): Int{
        return keyboard.readByte()
    }

    // Timer

    fun readTimer(): Int = timer.get()
    fun setTimer(v: Int) = timer.set(v)

    // Execution control

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
        timer.start()
        running = true
        try{
            while(running){
                val raw = fetch()
                if (raw == 0x0000) break
                factory.create(raw, this).execute(raw)
            }
        } catch(e: Exception){
            println("Program Terminated: ${e.message}")
        } finally{
            timer.stop()
        }
    }

}