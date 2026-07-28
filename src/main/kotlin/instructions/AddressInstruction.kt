package instructions

import cpu.CPU

abstract class AddressInstruction(cpu: CPU): Instruction(cpu) {

    protected var address: Int = 0

    final override fun decode(raw: Int){
        address = raw and 0xFFF // Lowest 3 nibbles gives us our 12 bit address
    }

}