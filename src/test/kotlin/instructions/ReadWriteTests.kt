package instructions

import cpu.CPU
import RomWriteException
import org.junit.jupiter.api.DisplayName
import testCpu
import kotlin.test.Test
import kotlin.test.assertFailsWith
import kotlin.test.assertEquals


@DisplayName("Test Read and Write Instructions")
class ReadWriteTests {

    @Test
    @DisplayName("Test Write and Read Instructions")
    fun testWriteThenRead() {
        val cpu = testCpu()
        cpu.setAddress(200)
        cpu.writeRegister(0, 42)
        Write(cpu).execute(0x4000)   // writes reg 0 to mem[A]
        // now read it back into a different register
        Read(cpu).execute(0x3100)    // reads mem[A] into reg 1
        assertEquals(42, cpu.readRegister(1))
    }

    @Test
    @DisplayName("Test writing to ROM throws")
    fun testWriteToRomThrows() {
        val cpu = testCpu()
        cpu.toggleMemoryBank()      // select ROM
        cpu.setAddress(0)
        cpu.writeRegister(0, 42)
        assertFailsWith<RomWriteException> {
            Write(cpu).execute(0x4000)
        }
    }
}
