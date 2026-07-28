package instructions

import cpu.CPU

class Draw(cpu: CPU): ThreeRegisterInstruction(cpu) {



    override fun perform() {
        cpu.drawToScreen(cpu.readRegister(x), y, z)
    }
}