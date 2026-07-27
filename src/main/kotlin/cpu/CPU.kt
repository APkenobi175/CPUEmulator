package cpu

class CPU {

    private val registers = ByteStorage(8)

    var programCounter: Int = 0

    fun readRegister(index: Int): Int{
        return registers.read(index)
    }

    fun writeRegister(index: Int, value: Int){
        registers.write(index, value)
    }

}