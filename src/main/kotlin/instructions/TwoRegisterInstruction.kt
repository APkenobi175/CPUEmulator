package instructions

import cpu.CPU

abstract class TwoRegisterInstruction(cpu: CPU) : Instruction(cpu) {

    protected var x: Int = 0
    protected var y: Int = 0

    final override fun decode(raw: Int){
        x = (raw shr 8) and 0xf // Nibble 2: Shift right by 8 and with 0xf to isolate
        y = (raw shr 4) and 0xf // Nibble 3: Shift right by 4 and with 0xf to isolate
    }
}