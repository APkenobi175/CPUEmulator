package instructions

import org.junit.jupiter.api.DisplayName
import testCpu
import kotlin.test.Test
import kotlin.test.assertTrue

@DisplayName("Test SimpleInstructionFactory")
class SimpleInstructionFactoryTest {

    private val factory = SimpleInstructionFactory()
    private val cpu = testCpu()

    @Test
    @DisplayName("Opcode maps to the correct instruction type")
    fun testOpcodeMapping() {
        assertTrue(factory.create(0x0000, cpu) is Store)
        assertTrue(factory.create(0x1000, cpu) is Add)
        assertTrue(factory.create(0x2000, cpu) is Sub)
        assertTrue(factory.create(0x3000, cpu) is Read)
        assertTrue(factory.create(0x4000, cpu) is Write)
        assertTrue(factory.create(0x5000, cpu) is Jump)
        assertTrue(factory.create(0x6000, cpu) is ReadKeyboard)
        assertTrue(factory.create(0x7000, cpu) is SwitchMemory)
        assertTrue(factory.create(0x8000, cpu) is SkipEqual)
        assertTrue(factory.create(0x9000, cpu) is SkipNotEqual)
        assertTrue(factory.create(0xA000, cpu) is SetA)
        assertTrue(factory.create(0xB000, cpu) is SetT)
        assertTrue(factory.create(0xC000, cpu) is ReadT)
        assertTrue(factory.create(0xD000, cpu) is ConvertToBase10)
        assertTrue(factory.create(0xE000, cpu) is ConvertByteToAscii)
        assertTrue(factory.create(0xF000, cpu) is Draw)
    }

    @Test
    @DisplayName("Only the opcode nibble determines the type")
    fun testIgnoresOperandNibbles() {
        // same opcode, different operands -> still an Add
        assertTrue(factory.create(0x1ABC, cpu) is Add)
    }
}