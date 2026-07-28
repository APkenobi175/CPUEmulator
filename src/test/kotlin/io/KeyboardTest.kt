package io

import org.junit.jupiter.api.DisplayName
import kotlin.test.Test
import kotlin.test.assertEquals

@DisplayName("Test Keyboard parsing")
class KeyboardTest {

    @Test
    @DisplayName("Empty input returns 0")
    fun testEmptyReturnsZero() {
        assertEquals(0, Keyboard().parse(""))
    }

    @Test
    @DisplayName("Single hex digit parses")
    fun testSingleHexDigit() {
        assertEquals(0xA, Keyboard().parse("A"))
    }

    @Test
    @DisplayName("Two hex digits parse as a byte")
    fun testTwoHexDigits() {
        assertEquals(0xFF, Keyboard().parse("FF"))
    }

    @Test
    @DisplayName("Only the first two digits are read")
    fun testOverlongTakesFirstTwo() {
        assertEquals(0x12, Keyboard().parse("1234"))
    }

    @Test
    @DisplayName("Lowercase hex is accepted")
    fun testLowercaseAccepted() {
        assertEquals(0xAB, Keyboard().parse("ab"))
    }
}