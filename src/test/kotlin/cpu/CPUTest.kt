package cpu

import instructions.Add
import instructions.Draw
import instructions.Sub
import org.junit.jupiter.api.DisplayName
import kotlin.test.Test
import kotlin.test.assertEquals


@DisplayName("Test CPU Functions")
class CPUTest {

    @Test
    @DisplayName("Program Counter Advances By 2 With Add Instructions")
    fun testProgramCounterAdd(){
        val cpu = CPU()
        Add(cpu).execute(0x1120)
        assertEquals(2, cpu.programCounter)
    }

    @Test
    @DisplayName("Program Counter Advances By 2 With Sub Instructions")
    fun testProgramCounterSub(){
        val cpu = CPU()
        Sub(cpu).execute(0x1120)
        assertEquals(2, cpu.programCounter)
    }

    @Test
    @DisplayName("Program Counter Advances By 2 With Draw Instructions")
    fun testDrawPcAdvances() {
        val cpu = CPU()
        cpu.writeRegister(0, 0x41)
        Draw(cpu).execute(0xF012)
        assertEquals(2, cpu.programCounter)
    }
}