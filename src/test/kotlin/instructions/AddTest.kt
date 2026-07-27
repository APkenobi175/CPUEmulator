package cpu

import instructions.Add
import org.junit.jupiter.api.DisplayName
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

@DisplayName("Test ROM object")
class AddTest {

    @Test
    @DisplayName("Add stores sum of two registers into third")
    fun testAddResult() {
        val cpu = CPU()
        cpu.writeRegister(1, 5)
        cpu.writeRegister(2, 3)
        Add(cpu).execute(0x1120) // opcode 1, x = 1, y = 2, z = 0
        assertEquals(8, cpu.readRegister(0))
    }
}