import cpu.Computer

fun main(){
    println("Enter path to program: ")
    val path = readlnOrNull() ?: return
    val computer = Computer()
    computer.load(path)
    computer.run()
}