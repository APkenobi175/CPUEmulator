package cpu

import instructions.Add
import instructions.Draw
import instructions.Sub
import io.Keyboard
import io.Screen
import org.junit.jupiter.api.DisplayName
import testCpu
import kotlin.test.Test
import kotlin.test.assertEquals


@DisplayName("Test CPU Functions")
class CPUTest {

    @Test
    @DisplayName("Program Counter Advances By 2 With Add Instructions")
    fun testProgramCounterAdd(){
        val cpu = testCpu()
        Add(cpu).execute(0x1120)
        assertEquals(2, cpu.programCounter)
    }

    @Test
    @DisplayName("Program Counter Advances By 2 With Sub Instructions")
    fun testProgramCounterSub(){
        val cpu = testCpu()
        Sub(cpu).execute(0x1120)
        assertEquals(2, cpu.programCounter)
    }

    @Test
    @DisplayName("Program Counter Advances By 2 With Draw Instructions")
    fun testDrawPcAdvances() {
        val cpu = testCpu()
        cpu.writeRegister(0, 0x41)
        Draw(cpu).execute(0xF012)
        assertEquals(2, cpu.programCounter)
    }

    @Test
    @DisplayName("Test Fetch Combines Two bytes")
    fun testFetchCombinesTwoBytes() {
        val rom = ROM()
        rom.load(byteArrayOf(0x12, 0x34))
        val cpu = CPU(rom, Screen(), Keyboard(), Timer())
        // fetch reads PC=0: high=0x12, low=0x34 -> 0x1234
        assertEquals(0x1234, cpu.fetch())
    }
}