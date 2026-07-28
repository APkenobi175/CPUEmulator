package cpu

import io.Screen

class CPU {

    private val registers = ByteStorage(8)
    private val ram = ByteStorage(4096)
    private val rom = ROM()
    var addressRegister: Int = 0
    var memoryFlag: Boolean = false // false = RAM, true = ROM

    var programCounter: Int = 0

    fun readRegister(index: Int): Int{
        return registers.read(index)
    }

    fun writeRegister(index: Int, value: Int){
        registers.write(index, value)
    }

    private val screen = Screen()

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

}