package io
import cpu.ByteStorage

class InvalidCharacterException(message: String) : Exception(message)

class Screen {
    private val buffer = ByteStorage(64)

    private fun toIndex(row: Int, column: Int): Int{
        return row * 8 + column // screen is 8x8 so to find index take row * 8 and add it to what column number we are on
    }

    fun draw(value: Int, row: Int, column: Int){
        if (value > 0x7F){
            throw InvalidCharacterException("Value $value is not a valid character to print to screen")
        }
        buffer.write(toIndex(row, column), value)
    }

    fun render(){
        for (row in 0 until 8){
            for (col in 0 until 8){
                val b = buffer.read(toIndex(row, col))
                print(if(b < 0x20) ' ' else b.toChar())
            }
            println() // new line
        }
    }

    private fun clear(){
        for (i in 0 until buffer.size){
            buffer.write(i, 0)
        }
    }
}

