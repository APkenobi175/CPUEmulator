package instructions

import cpu.CPU
import RomWriteException
import org.junit.jupiter.api.DisplayName
import kotlin.test.Test
import kotlin.test.assertFailsWith
import kotlin.test.assertEquals


@DisplayName("Test Read and Write Instructions")
class ReadWriteTests {

    @Test
    @DisplayName("Test Write and Read Instructions")
    fun testWriteThenRead() {
        val cpu = CPU()
        cpu.addressRegister = 100
        cpu.writeRegister(0, 42)
        Write(cpu).execute(0x4000)   // writes reg 0 to mem[A]
        // now read it back into a different register
        Read(cpu).execute(0x3100)    // reads mem[A] into reg 1
        assertEquals(42, cpu.readRegister(1))
    }

    @Test
    @DisplayName("Test writing to ROM throws")
    fun testWriteToRomThrows() {
        val cpu = CPU()
        cpu.memoryFlag = true          // select ROM
        cpu.addressRegister = 0
        cpu.writeRegister(0, 42)
        assertFailsWith<RomWriteException> {
            Write(cpu).execute(0x4000)
        }
    }
}
