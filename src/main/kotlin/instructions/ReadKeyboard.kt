package instructions

import cpu.CPU

class ReadKeyboard(cpu: CPU) : OneRegisterInstruction(cpu) {
    override fun perform(){
        cpu.writeRegister(x, cpu.awaitKeyPress())
    }
}