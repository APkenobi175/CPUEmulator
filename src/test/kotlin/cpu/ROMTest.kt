package cpu

import org.junit.jupiter.api.DisplayName
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

@DisplayName("Test ROM object")
class ROMTest {

    @Test
    @DisplayName("Writing to a non-writable ROM throws RomWriteException")
    fun testWriteToLockedRomThrows() {
        val rom = ROM()
        assertFailsWith<RomWriteException> {
            rom.write(0, 123)
        }
    }

    @Test
    @DisplayName("Writing to a writable ROM succeeds")
    fun testWriteToWritableRomSucceeds() {
        val rom = ROM(writable = true)
        rom.write(0, 123)
        assertEquals(123, rom.read(0))
    }

    @Test
    @DisplayName("Loaded bytes can be read back")
    fun testLoadReadBack() {
        val rom = ROM()
        rom.load(byteArrayOf(0x12, 0x34, 0xFF.toByte()))
        assertEquals(0x12, rom.read(0))
        assertEquals(0x34, rom.read(1))
        assertEquals(255, rom.read(2))   // 0xFF read back through the and 0xFF mask
    }

    @Test
    @DisplayName("Loading a program larger than ROM throws")
    fun testLoadOversizedThrows() {
        val rom = ROM()
        val tooBig = ByteArray(4097)
        assertFailsWith<IllegalArgumentException> {
            rom.load(tooBig)
        }
    }

    @Test
    @DisplayName("Unused ROM past the loaded program reads as zero")
    fun testUnusedRomIsZero() {
        val rom = ROM()
        rom.load(byteArrayOf(0x12, 0x34))
        assertEquals(0, rom.read(2))     // nothing loaded here halts on 0000
    }
}