package cpu

import instructions.Sub
import org.junit.jupiter.api.DisplayName
import kotlin.test.Test
import kotlin.test.assertEquals


@DisplayName("Test ROM object")
class SubTest {

    @Test
    @DisplayName("Sub stores difference of two registers into third")
    fun testAddResult() {
        val cpu = CPU()
        cpu.writeRegister(1, 5)
        cpu.writeRegister(2, 3)
        Sub(cpu).execute(0x1120) // opcode 1, x = 1, y = 2, z = 0
        assertEquals(2, cpu.readRegister(0))
    }
}