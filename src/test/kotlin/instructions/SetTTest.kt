package instructions

import org.junit.jupiter.api.DisplayName
import testCpu
import kotlin.test.Test
import kotlin.test.assertEquals

@DisplayName("Test SetT Instruction")
class SetTTest {

    @Test
    @DisplayName("SetT sets the timer to the immediate byte")
    fun testSetTValue() {
        val cpu = testCpu()
        SetT(cpu).execute(0xB0A0)          // data sheet example: T = 0x0A
        assertEquals(0x0A, cpu.readTimer())
    }

    @Test
    @DisplayName("SetT reads the full byte, not a nibble")
    fun testSetTFullByte() {
        val cpu = testCpu()
        SetT(cpu).execute(0xBFF0)          // T = 0xFF
        assertEquals(0xFF, cpu.readTimer())
    }
}