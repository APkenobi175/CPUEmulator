package cpu

import org.junit.jupiter.api.DisplayName
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

@DisplayName("Test ByteStorage Base object")
class ByteStorageTest {

    @Test
    @DisplayName("Write and Read returns same value")
    fun testReadWrite(){
        val storage = ByteStorage(16)
        storage.write(0, 200)
        assertEquals(200, storage.read(0))
    }

    @Test
    @DisplayName("Test value of 256 wraps to 0")
    fun testWrap(){
        val storage = ByteStorage(16)
        storage.write(0, 256)
        assertEquals(0, storage.read(0))
    }

    @Test
    @DisplayName("Value of 255 Reads as 255 and not -1")
    // this test makes sure we are correctly bitwise ANDing so that a 11111111 doesn't come back as
    // the signed int of -1 and that we're correctly ANDing 0xFF off to convert it to 255
    fun testRead255(){
        val storage = ByteStorage(16)
        storage.write(0, 255)
        assertEquals(255, storage.read(0))
    }

    @Test
    @DisplayName("Value of 300 wraps to 44")
    // This test makes sure we are correctly wrapping rather than going to negatives
    fun testWrap2(){
        val storage = ByteStorage(16)
        storage.write(0, 300)
        assertEquals(44, storage.read(0))
    }

    @Test
    @DisplayName("Reading at index equal to size throws Exception")
    fun testEqualIndexThrows(){
        val storage = ByteStorage(16)
        assertFailsWith<IndexOutOfBoundsException>{
            storage.read(16)
        }
    }

    @Test
    @DisplayName("Reading at a negative index throws Exception")
    fun testNegativeIndexThrows(){
        val storage = ByteStorage(16)
        assertFailsWith<IndexOutOfBoundsException>{
            storage.read(-2)
        }
    }

    @Test
    @DisplayName("Reading at a index greater than size throws Exception")
    fun testGreaterThanSizeThrows(){
        val storage = ByteStorage(16)
        assertFailsWith<IndexOutOfBoundsException>{
            storage.read(123)
        }
    }

    @Test
    @DisplayName("Writing at an index equal to size throws Exception")
    fun testEqualIndexThrows2(){
        val storage = ByteStorage(16)
        assertFailsWith<IndexOutOfBoundsException>{
            storage.write(16, 123)
        }
    }

    @Test
    @DisplayName("Writing at a negative index throws Exception")
    fun testNegativeIndexThrows2(){
        val storage = ByteStorage(16)
        assertFailsWith<IndexOutOfBoundsException>{
            storage.write(-2, 123)
        }
    }

    @Test
    @DisplayName("Writing at an index greater than size throws Exception")
    fun testGreaterThanSizeThrows2(){
        val storage = ByteStorage(16)
        assertFailsWith<IndexOutOfBoundsException>{
            storage.write(19, 123)
        }
    }

    @Test
    @DisplayName("Ensure fresh storage is all zero")
    fun testFreshStorage(){
        val storage = ByteStorage(16)
        for (i in 0 until 16){
            assertEquals(0, storage.read(i))

        }
    }


}