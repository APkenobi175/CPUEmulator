package cpu

open class ByteStorage (val size: Int) {
    protected val data: ByteArray = ByteArray(size)

    fun read(index: Int): Int{
        // Read the data at the passed in index
        checkBounds(index)
        return data[index].toInt() and 0xFF
    }

    open fun write(index: Int, value: Int) {
        // Write data to passed in index
        checkBounds(index)
        data[index] = (value and 0xFF).toByte()
    }

    protected fun checkBounds(index: Int){
        // Helper method to determine if the index is valid and is in bounds of the ByteArray
        if (index !in 0..<size){
            throw IndexOutOfBoundsException("Index $index is out of bounds for ByteStorage size $size")
        }
    }


}