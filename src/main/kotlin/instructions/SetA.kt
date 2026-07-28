package instructions
import cpu.CPU
class SetA(cpu: CPU): AddressInstruction(cpu) {
    override fun perform(){
        cpu.addressRegister = address
    }
}