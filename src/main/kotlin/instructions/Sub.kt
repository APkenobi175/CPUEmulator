package instructions

import cpu.CPU

class Sub(cpu: CPU) : ThreeRegisterInstruction(cpu) {
    override fun perform() {
        // Store x - y into register z
        cpu.writeRegister(z, cpu.readRegister(x) - cpu.readRegister(y))
    }
}