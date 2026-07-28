package instructions

import cpu.CPU
import org.junit.jupiter.api.DisplayName
import kotlin.test.Test
import kotlin.test.assertEquals

@DisplayName("Test ReadT Instruction")
class ReadTTest {

    @Test
    @DisplayName("ReadT stores the timer value into register x")
    fun testReadTStoresTimerValue() {
        val cpu = CPU()
        cpu.setTimer(55)                  // set a known timer value
        ReadT(cpu).execute(0xC100)        // x=1
        assertEquals(55, cpu.readRegister(1))
    }
}