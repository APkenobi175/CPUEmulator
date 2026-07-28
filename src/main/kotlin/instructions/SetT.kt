package instructions

import cpu.CPU

class SetT(cpu: CPU) : Instruction(cpu) {
    private var immediate = 0
    override fun decode(raw: Int){
        immediate = (raw shr 4) and 0xFF // Nibble 2+3
    }

    override fun perform(){
        cpu.setTimer(immediate)
    }
}