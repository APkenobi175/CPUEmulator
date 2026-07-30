package cpu

import instructions.SimpleInstructionFactory
import io.ConsoleScreen
import io.Keyboard


// Evalith Feedback: Keep instantiations out of Computer. Computer receives its collaborators instead of constructing them
// This class also keeps the construction out of Main so main can have 2 simple lines of code. Computer.load(path) and Computer.run()


object ComputerFactory {

    fun createComputer(): Computer{
        val rom = ROM()
        val screen = ConsoleScreen()
        val keyboard = Keyboard()
        val timer = Timer()
        val cpu = CPU(rom, screen, keyboard, timer, SimpleInstructionFactory())
        return Computer(rom, cpu)
    }
}