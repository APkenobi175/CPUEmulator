import cpu.ComputerFactory

fun main(){
    println("Enter path to program: ")
    val path = readlnOrNull() ?: return
    val computer = ComputerFactory.createComputer()
    // Facade Pattern: All moving parts hook into computer Object
    computer.load(path)
    computer.run()
}