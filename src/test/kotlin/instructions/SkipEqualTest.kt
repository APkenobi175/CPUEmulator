package instructions

import cpu.CPU
import org.junit.jupiter.api.DisplayName
import kotlin.test.Test
import kotlin.test.assertEquals

@DisplayName("Test SkipEqual Instruction")
class SkipEqualTest {

    @Test
    @DisplayName("Equal registers skip the next instruction (PC += 4)")
    fun testSkipsWhenEqual() {
        val cpu = CPU()
        cpu.writeRegister(1, 42)
        cpu.writeRegister(2, 42)
        SkipEqual(cpu).execute(0x8120)   // x=1, y=2
        assertEquals(4, cpu.programCounter)
    }

    @Test
    @DisplayName("Unequal registers do not skip (PC += 2)")
    fun testNoSkipWhenNotEqual() {
        val cpu = CPU()
        cpu.writeRegister(1, 42)
        cpu.writeRegister(2, 7)
        SkipEqual(cpu).execute(0x8120)
        assertEquals(2, cpu.programCounter)
    }
}