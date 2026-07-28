package io

interface Display {
    fun draw(value: Int, row: Int, column: Int)
    fun render()
    fun clear()
}