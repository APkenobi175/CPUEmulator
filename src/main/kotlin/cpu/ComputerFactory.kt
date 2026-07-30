package cpu

import instructions.InstructionFactory
import io.Display
import io.InputDevice



// Evalith Feedback: Keep instantiations out of Computer. Computer receives its collaborators instead of constructing them
// This class also keeps the construction out of Main so main can have 2 simple lines of code. Computer.load(path) and Computer.run()


object ComputerFactory {
    fun create(
        screen: Display,
        keyboard: InputDevice,
        timer: Timer,
        factory: InstructionFactory // Evalith feedback part 3: This is better but hard coded, this section removes the hardcodedness
    ): Computer {
        val rom = ROM()
        val cpu = CPU(rom, screen, keyboard, timer, factory)
        return Computer(rom, cpu)
    }
}