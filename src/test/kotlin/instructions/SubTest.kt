package cpu

import instructions.Add
import instructions.Sub
import org.junit.jupiter.api.DisplayName
import testCpu
import kotlin.test.Test
import kotlin.test.assertEquals


@DisplayName("Test Sub Instruction")
class SubTest {

    @Test
    @DisplayName("Sub stores difference of two registers into third")
    fun testSubResult() {
        val cpu = testCpu()
        cpu.writeRegister(1, 5)
        cpu.writeRegister(2, 3)
        Sub(cpu).execute(0x1120) // opcode 1, x = 1, y = 2, z = 0
        assertEquals(2, cpu.readRegister(0))
    }

    @Test
    @DisplayName("Sub wraps on underflow")
    fun testSubWraps() {
        val cpu = testCpu()
        cpu.writeRegister(1, 3)
        cpu.writeRegister(2, 5)
        Sub(cpu).execute(0x1120)
        assertEquals(254, cpu.readRegister(0))  // 3 - 5 wraps to 254
    }
}