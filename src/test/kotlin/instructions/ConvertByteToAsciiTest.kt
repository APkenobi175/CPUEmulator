package instructions

import cpu.CPU
import InvalidCharacterException
import org.junit.jupiter.api.DisplayName
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

@DisplayName("Test ConvertByteToAscii Instruction")
class ConvertByteToAsciiTest {

    @Test
    @DisplayName("Digit 5 converts to ASCII '5' (0x35)")
    fun testConvertsDigitBelowTen() {
        val cpu = CPU()
        cpu.writeRegister(0, 0x5)
        ConvertByteToAscii(cpu).execute(0xE010)   // x=0, y=1
        assertEquals(0x35, cpu.readRegister(1))
    }

    @Test
    @DisplayName("Digit 0xC converts to ASCII 'C' (0x43) across the gap")
    fun testConvertsDigitAboveNine() {
        val cpu = CPU()
        cpu.writeRegister(0, 0xC)
        ConvertByteToAscii(cpu).execute(0xE010)
        assertEquals(0x43, cpu.readRegister(1))
    }

    @Test
    @DisplayName("Value greater than 0xF throws")
    fun testThrowsOnNonHexDigit() {
        val cpu = CPU()
        cpu.writeRegister(0, 0x10)
        assertFailsWith<InvalidCharacterException> {
            ConvertByteToAscii(cpu).execute(0xE010)
        }
    }
}