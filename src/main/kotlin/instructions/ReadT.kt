package instructions
import cpu.CPU
class ReadT(cpu: CPU) : OneRegisterInstruction(cpu) {
    override fun perform() {
        cpu.writeRegister(x, cpu.readTimer())
    }
}