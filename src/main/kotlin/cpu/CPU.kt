package cpu

import io.Screen

class CPU {

    private val registers = ByteStorage(8)

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

}