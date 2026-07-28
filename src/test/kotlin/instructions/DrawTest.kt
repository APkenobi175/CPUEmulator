package instructions

import cpu.CPU
import InvalidCharacterException
import org.junit.jupiter.api.DisplayName
import testCpu
import kotlin.test.Test
import kotlin.test.assertFailsWith


@DisplayName("Test Draw Instruction")
class DrawTest {

    @Test
    @DisplayName("Draw throws when value exceeds 0x7F")
    fun testDrawInvalidChar() {
        val cpu = testCpu()
        cpu.writeRegister(0, 0x80)   // 128, one past valid ASCII
        cpu.writeRegister(1, 0)      // row
        cpu.writeRegister(2, 0)      // col
        assertFailsWith<InvalidCharacterException> {
            Draw(cpu).execute(0xF012)   // x=0, y=1, z=2
        }
    }

    @Test
    @DisplayName("Draw with valid char does not throw")
    fun testDrawValidChar() {
        val cpu = testCpu()
        cpu.writeRegister(0, 0x41)   // 'A'
        cpu.writeRegister(1, 0)
        cpu.writeRegister(2, 0)
        Draw(cpu).execute(0xF012)    // should complete without throwing
    }


}