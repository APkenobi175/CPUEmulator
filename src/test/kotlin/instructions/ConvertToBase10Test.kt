package instructions

import org.junit.jupiter.api.DisplayName
import testCpu
import kotlin.test.Test
import kotlin.test.assertEquals


@DisplayName("Test Convert To Base 10 Instruction")
class ConvertToBase10Test {

    @Test
    @DisplayName("Test Convert to Base 10 with 3 digits")
    fun testConvertThreeDigits() {
        val cpu = testCpu()
        cpu.setAddress(200)
        cpu.writeRegister(0, 255)
        ConvertToBase10(cpu).execute(0xD000)
        assertEquals(2, cpu.readMemory(0))   // hundreds at A
        assertEquals(5, cpu.readMemory(1))   // tens at A+1
        assertEquals(5, cpu.readMemory(2))   // ones at A+2
    }

    @Test
    @DisplayName("Test convert to base 10 with single digits")
    fun testConvertSingleDigit() {
        val cpu = testCpu()
        cpu.setAddress(200)
        cpu.writeRegister(0, 7)
        ConvertToBase10(cpu).execute(0xD000)
        assertEquals(0, cpu.readMemory(0))   // hundreds = 0
        assertEquals(0, cpu.readMemory(1))   // tens = 0
        assertEquals(7, cpu.readMemory(2))   // ones = 7
    }
}