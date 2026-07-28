package instructions
import cpu.CPU
class ConvertToBase10(cpu: CPU): OneRegisterInstruction(cpu) {
    override fun perform() {
        val value = cpu.readRegister(x)
        cpu.writeMemory(value / 100, 0) // Hundreds at A
        cpu.writeMemory((value / 10) % 10, 1) // Tens at A+1
        cpu.writeMemory(value % 10, 2) // ones at A+2
    }
}