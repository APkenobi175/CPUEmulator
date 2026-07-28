package instructions

import cpu.CPU

class SkipEqual(cpu: CPU) : TwoRegisterInstruction(cpu) {
    private var shouldSkip = false

    override fun perform(){
        shouldSkip = cpu.readRegister(x) == cpu.readRegister(y)

    }

    override fun pcIncrement(): Int{
        // Increment PC by 4 if skip
        return if (shouldSkip) 4 else 2
    }
}