package com.example.rrulepractice.utils

import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import org.junit.runners.Parameterized.Parameters

@RunWith(value = Parameterized::class)
class PallindromParameterizedTest(val input: String, val expectedValue: Boolean) {

    @Test
    fun test() {
        val pallindrom = Pallindrom()
        val result = pallindrom.isPallindrom(input = input)
        Assert.assertEquals(expectedValue, result)
    }

    companion object {

        @JvmStatic
        @Parameters(name = "{index} : {0} is pallindrom - {1}")
        fun data(): List<Array<Any>> {
            return listOf(
                arrayOf("hello", false),
                arrayOf("level", true),
                arrayOf("a", true),
                arrayOf(" ", true),
            )
        }
    }
}