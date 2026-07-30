import cpu.CPU
import io.Keyboard
import io.ConsoleScreen
import cpu.ROM
import cpu.Timer
import instructions.SimpleInstructionFactory

// in a test util, or private fun in each test file
fun testCpu() = CPU(ROM(), ConsoleScreen(), Keyboard(), Timer(), SimpleInstructionFactory())