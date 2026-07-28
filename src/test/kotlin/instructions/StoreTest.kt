package instructions

import cpu.CPU
import org.junit.jupiter.api.DisplayName
import testCpu
import kotlin.test.Test
import kotlin.test.assertEquals

@DisplayName("Test Store Instruction")
class StoreTest {

    @Test
    @DisplayName("Store puts the immediate byte into register x")
    fun testStoreValue() {
        val cpu = testCpu()
        Store(cpu).execute(0x00FF)         // x=0, immediate=0xFF
        assertEquals(0xFF, cpu.readRegister(0))
    }

    @Test
    @DisplayName("Store targets the correct register")
    fun testStoreTargetsRegister() {
        val cpu = testCpu()
        Store(cpu).execute(0x0342)         // x=3, immediate=0x42
        assertEquals(0x42, cpu.readRegister(3))
    }
}