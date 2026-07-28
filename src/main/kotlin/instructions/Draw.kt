package instructions

import cpu.CPU
import io.Screen

class Draw(cpu: CPU): ThreeRegisterInstruction(cpu) {



    override fun perform() {
        cpu.drawToScreen(cpu.readRegister(x), y, z)
    }
}