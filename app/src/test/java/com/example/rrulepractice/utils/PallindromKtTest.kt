package com.example.rrulepractice.utils

import org.junit.Assert
import org.junit.Before
import org.junit.Test

class PallindromKtTest {
    private lateinit var pallindrom: Pallindrom

    @Before
    fun setUp() {
        pallindrom = Pallindrom()
    }

    @Test
    fun isPallindrom_inputString_hello_expectedFalse() {
        val result = pallindrom.isPallindrom("hello")
        Assert.assertEquals(false, result)
    }

    @Test
    fun isPallindrom_inputString_level_expectedTrue() {
        val result = pallindrom.isPallindrom("level")
        Assert.assertEquals(true, result)
    }

    @Test
    fun isPallindrom_inputString_a_expectedTrue() {
        val result = pallindrom.isPallindrom("a")
        Assert.assertEquals(true, result)
    }

    @Test
    fun isPallindrom_inputString_empty_expectedTrue() {
        val result = pallindrom.isPallindrom(" ")
        Assert.assertEquals(true, result)
    }
}