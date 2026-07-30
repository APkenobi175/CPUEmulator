package instructions

import org.junit.jupiter.api.DisplayName
import testCpu
import kotlin.test.Test
import kotlin.test.assertEquals

@DisplayName("Test SkipNotEqual Instruction")
class SkipNotEqualTest {

    @Test
    @DisplayName("Unequal registers skip the next instruction (PC += 4)")
    fun testSkipsWhenNotEqual() {
        val cpu = testCpu()
        cpu.writeRegister(1, 42)
        cpu.writeRegister(2, 7)
        SkipNotEqual(cpu).execute(0x9120)
        assertEquals(4, cpu.getCurrentAddress())
    }

    @Test
    @DisplayName("Equal registers do not skip (PC += 2)")
    fun testNoSkipWhenEqual() {
        val cpu = testCpu()
        cpu.writeRegister(1, 42)
        cpu.writeRegister(2, 42)
        SkipNotEqual(cpu).execute(0x9120)
        assertEquals(2, cpu.getCurrentAddress())
    }
}