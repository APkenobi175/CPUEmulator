package instructions

import cpu.CPU

class SwitchMemory(cpu: CPU) : Instruction(cpu) {

    override fun decode(raw: Int){
        // nothing happens
    }

    override fun perform(){
        cpu.memoryFlag = !cpu.memoryFlag
    }
}