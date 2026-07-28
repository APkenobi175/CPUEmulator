package instructions

import cpu.CPU

class Read(cpu: CPU): OneRegisterInstruction(cpu) {
    override fun perform(){
        cpu.writeRegister(x, cpu.readMemory())
    }
}