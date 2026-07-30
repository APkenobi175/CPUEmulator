package instructions

import cpu.CPU

class SimpleInstructionFactory: InstructionFactory {

    private fun opcode(raw: Int): Int = (raw shr 12) and 0xF

    override fun create(raw: Int, cpu: CPU): Instruction {
        return when (opcode(raw)) {
            0x0 -> Store(cpu)
            0x1 -> Add(cpu)
            0x2 -> Sub(cpu)
            0x3 -> Read(cpu)
            0x4 -> Write(cpu)
            0x5 -> Jump(cpu)
            0x6 -> ReadKeyboard(cpu)
            0x7 -> SwitchMemory(cpu)
            0x8 -> SkipEqual(cpu)
            0x9 -> SkipNotEqual(cpu)
            0xA -> SetA(cpu)
            0xB -> SetT(cpu)
            0xC -> ReadT(cpu)
            0xD -> ConvertToBase10(cpu)
            0xE -> ConvertByteToAscii(cpu)
            0xF -> Draw(cpu)
            else -> throw IllegalStateException("Unreachable: opcode is 0-F")
        }
    }
}