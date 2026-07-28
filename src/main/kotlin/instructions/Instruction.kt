package instructions

import cpu.CPU

abstract class Instruction(protected val cpu: CPU) {

    protected abstract fun decode(raw: Int)
    protected abstract fun perform()

    // Default increment of 2
    protected open fun pcIncrement(): Int{
        return 2
    }

    fun execute(raw: Int){
        decode(raw)
        perform()
        cpu.advanceProgramCounter(pcIncrement())
    }
}