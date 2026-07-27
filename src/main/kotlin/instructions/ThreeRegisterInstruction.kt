package instructions

import cpu.CPU

abstract class ThreeRegisterInstruction(cpu: CPU): Instruction(cpu) {

    protected var x: Int = 0
    protected var y: Int = 0
    protected var z: Int = 0

    final override fun decode(raw: Int){
        // Nibble 0 = opcode already used by factory

        // Nibble 1: Shift out 2 nibbles, mask with 0xF to isolate
        x = (raw shr 8) and 0xF
        // Nibble 2: Shift out 1 nibble, mask with 0xF to isolate
        y = (raw shr 4) and 0xF
        // Nibble 3: Mask with 0xF to isolate
        z = raw and 0xF
    }

}