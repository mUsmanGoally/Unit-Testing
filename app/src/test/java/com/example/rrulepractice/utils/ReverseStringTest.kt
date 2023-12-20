package com.example.rrulepractice.utils

import org.junit.Assert.*

import org.junit.Before
import org.junit.Test

class ReverseStringTest {

    private lateinit var reverseString: ReverseString

    @Before
    fun setUp() {
        reverseString = ReverseString()
    }

    @Test
    fun reverseString() {
        val result = reverseString.reverseString("usman")
        assertEquals("namsu", result)
    }

    @Test(expected = IllegalArgumentException::class)
    fun reverseString_input_empty_expected_exception() {
        reverseString.reverseString("")
    }
}