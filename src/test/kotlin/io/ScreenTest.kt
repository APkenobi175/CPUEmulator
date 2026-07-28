package io

import org.junit.jupiter.api.DisplayName
import kotlin.test.Test
import kotlin.test.assertEquals


@DisplayName("Test Screen Interaction")
class ScreenTest {

    @Test
    @DisplayName("Test Clear Zeroes Buffer")
    fun testClearZeroesBuffer() {
        val screen = ConsoleScreen()
        screen.draw(0x41, 2, 3)
        screen.clear()               // needs to be non-private
        assertEquals(0, screen.read(2, 3))
    }

    @Test
    @DisplayName("Test Draw One Character")
    fun testDrawLandsAtCoordinates() {
        val screen = ConsoleScreen()
        screen.draw(0x41, 5, 6)
        assertEquals(0x41, screen.read(5, 6))
    }
}