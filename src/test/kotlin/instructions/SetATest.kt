package instructions

import cpu.CPU
import org.junit.jupiter.api.DisplayName
import testCpu
import kotlin.test.Test
import kotlin.test.assertEquals

@DisplayName("Test SetA Instruction")
class SetATest {

    @Test
    @DisplayName("SetA stores the 12-bit address in the address register")
    fun testSetAStoresAddress() {
        val cpu = testCpu()
        SetA(cpu).execute(0xA255)          // address = 0x255
        assertEquals(0x255, cpu.addressRegister)
    }

    @Test
    @DisplayName("SetA advances the program counter by 2")
    fun testSetAAdvancesPc() {
        val cpu = testCpu()
        SetA(cpu).execute(0xA255)
        assertEquals(2, cpu.programCounter)
    }
}