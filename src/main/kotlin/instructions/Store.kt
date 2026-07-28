package instructions

import cpu.CPU

class Store(cpu: CPU): Instruction(cpu) {
    private var x = 0
    private var immediate = 0

    override fun decode(raw: Int){
        x = (raw shr 8) and 0xF // Register: Nibbl2
        immediate = raw and 0xFF // value: nibble 3 and 4\

    }

    override fun perform(){
        cpu.writeRegister(x, immediate)
    }
}