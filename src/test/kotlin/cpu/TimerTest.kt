package cpu

import org.junit.jupiter.api.DisplayName
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

@DisplayName("Test Timer")
class TimerTest {

    @Test
    @DisplayName("Set then get returns the same value")
    fun testSetThenGet() {
        val timer = Timer()
        timer.set(100)
        assertEquals(100, timer.get())
    }

    @Test
    @DisplayName("Set masks values to 8 bits")
    fun testSetMasks() {
        val timer = Timer()
        timer.set(300)
        assertEquals(44, timer.get())   // 300 and 0xFF = 44
    }

    @Test
    @DisplayName("Fresh timer reads zero")
    fun testFreshTimerIsZero() {
        val timer = Timer()
        assertEquals(0, timer.get())
    }

    @Test
    @DisplayName("Timer decrements over time while running")
    fun testDecrementsOverTime() {
        val timer = Timer()
        timer.set(200)
        timer.start()
        Thread.sleep(100)
        timer.stop()
        val value = timer.get()
        assertTrue(value in 181..199, "expected value to drop but stay well above 0, was $value")
    }

    @Test
    @DisplayName("Timer stops at zero and does not wrap")
    fun testStopsAtZero() {
        val timer = Timer()
        timer.set(3)
        timer.start()
        Thread.sleep(200)
        timer.stop()
        assertEquals(0, timer.get(), "timer should clamp at 0, not wrap to 255")
    }
}