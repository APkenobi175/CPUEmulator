package io

class Keyboard: InputDevice {

    override fun readByte(): Int {

        while (true) {
            print("Input (hex): ")
            val input = readlnOrNull() ?: ""
            try {
                return parse(input)
            } catch (e: NumberFormatException) {
                println("Invalid Input. Enter up to 2 hex digits (0-F)")
            }
        }
    }


    // If I make this internal instead of private my unit tests can access it
    internal fun parse(input: String): Int{
        if (input.isEmpty()) return 0
        val trimmed = input.take(2) // take 2 digits at most
        return trimmed.toInt(16)  // parse as hex
    }
}