package cpu

class ROM(private val writable: Boolean = false): ByteStorage(4096) {

    override fun write(index: Int, value: Int){
        if (!writable){
            throw RomWriteException("Cannot write to ROM, ROM is NOT writable")
        }

        super.write(index, value)
    }

    fun load(bytes: ByteArray){
        if (bytes.size > size){
            throw IllegalArgumentException("Program is ${bytes.size} bytes, exceeds ROM size $size")
        }
        bytes.copyInto(data)
        // Access via ROM.data
    }


}


// Custom exception for trying to write to read only memory
class RomWriteException(message: String): Exception(message)