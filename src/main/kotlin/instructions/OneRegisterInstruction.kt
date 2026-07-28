package instructions

import cpu.CPU
abstract class OneRegisterInstruction(cpu: CPU) : Instruction(cpu) {

    protected var x: Int = 0
    final override fun decode(raw: Int) {
        x = (raw shr 8) and 0xF // Nibble 2: Shift right by 8 and with 0xF to isolate
    }

}