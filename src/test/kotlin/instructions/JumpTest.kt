package instructions

import JumpException
import org.junit.jupiter.api.DisplayName
import testCpu
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

@DisplayName("Test Jump Instruction")
class JumpTest {

    @Test
    @DisplayName("Jump sets the program counter to an even address")
    fun testJumpSetsProgramCounter() {
        val cpu = testCpu()
        Jump(cpu).execute(0x51F2)          // address = 0x1F2 (even)
        assertEquals(0x1F2, cpu.currentAddress())
    }

    @Test
    @DisplayName("Jump does not add the default increment to its target")
    fun testJumpDoesNotIncrement() {
        val cpu = testCpu()
        Jump(cpu).execute(0x5100)          // address = 0x100
        assertEquals(0x100, cpu.currentAddress())   // exactly 0x100, not 0x102
    }

    @Test
    @DisplayName("Jump to an odd address throws")
    fun testJumpOddAddressThrows() {
        val cpu = testCpu()
        assertFailsWith<JumpException> {
            Jump(cpu).execute(0x51F3)      // address = 0x1F3 (odd)
        }
    }
}