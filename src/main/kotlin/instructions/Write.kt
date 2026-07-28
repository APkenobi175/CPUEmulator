package instructions

import cpu.CPU

class Write(cpu: CPU): OneRegisterInstruction(cpu) {
    override fun perform() {
        cpu.writeMemory(cpu.readRegister(x))
    }

}