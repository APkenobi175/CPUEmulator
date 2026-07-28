import cpu.CPU
import io.Keyboard
import io.Screen
import cpu.ROM
import cpu.Timer

// in a test util, or private fun in each test file
fun testCpu() = CPU(ROM(), Screen(), Keyboard(), Timer())