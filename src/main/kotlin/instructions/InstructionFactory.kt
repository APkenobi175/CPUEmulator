package instructions

import cpu.CPU

interface InstructionFactory {
    fun create(raw: Int, cpu: CPU): Instruction
}