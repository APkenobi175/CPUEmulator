package instructions

import InvalidCharacterException
import cpu.CPU

class ConvertByteToAscii(cpu: CPU): TwoRegisterInstruction(cpu) {

    override fun perform() {
        val digit = cpu.readRegister(x)
        if (digit > 0xF){
            throw InvalidCharacterException("Value $digit is not a hex digit (0-F")
        }

        val ascii = if (digit < 10){
            digit + 0x30
        }else{
            digit - 10 + 0x41
        }

        cpu.writeRegister(y, ascii)
    }
}