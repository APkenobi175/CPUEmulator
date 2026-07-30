import cpu.ComputerFactory
import cpu.Timer
import instructions.SimpleInstructionFactory
import io.ConsoleScreen
import io.Keyboard

fun main(){
    println("Enter path to program: ")
    val path = readlnOrNull() ?: return
    val computer = ComputerFactory.create(ConsoleScreen(), Keyboard(), Timer(), SimpleInstructionFactory())
    // Facade Pattern: All moving parts hook into computer Object
    computer.load(path)
    computer.run()
}