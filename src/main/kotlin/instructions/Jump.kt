package instructions
import JumpException
import cpu.CPU
class Jump(cpu: CPU): AddressInstruction(cpu) {
    override fun perform() {
        if (address % 2 != 0){
            throw JumpException("Invalid address: $address")
        }
        cpu.jumpTo(address)
    }

    // Don't increment PC
    override fun pcIncrement(): Int = 0
}