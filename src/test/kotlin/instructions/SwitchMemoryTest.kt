package instructions

import cpu.CPU
import org.junit.jupiter.api.DisplayName
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue
import testCpu


@DisplayName("Test SwitchMemory Instruction")
class SwitchMemoryTest {

    @Test
    @DisplayName("SwitchMemory toggles the flag from false to true")
    fun testToggleFromFalse() {
        val cpu = testCpu()
        // starts false (RAM)
        SwitchMemory(cpu).execute(0x7000)
        assertTrue(cpu.getMemoryBank())
    }

    @Test
    @DisplayName("SwitchMemory toggles the flag from true to false")
    fun testToggleFromTrue() {
        val cpu = testCpu()
        cpu.toggleMemoryBank()
        SwitchMemory(cpu).execute(0x7000)
        assertFalse(cpu.getMemoryBank())
    }
}