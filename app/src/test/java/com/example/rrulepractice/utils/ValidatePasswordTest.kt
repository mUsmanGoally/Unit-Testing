package com.example.rrulepractice.utils

import org.junit.Assert
import org.junit.Before
import org.junit.Test

class ValidatePasswordTest {
    private lateinit var validatePassword: ValidatePassword

    @Before
    fun setUp() {
        validatePassword = ValidatePassword()
    }

    @Test
    fun isPasswordValid_inputString_empty_expected_emptyPassword() {
        val result = validatePassword.isPasswordValid("")
        Assert.assertEquals("password is empty", result)
    }

    @Test
    fun isPasswordValid_inputString_invalidPassword_expected_wrongPassword() {
        val result = validatePassword.isPasswordValid("12hjh8767867867786786878688678678")
        Assert.assertEquals("password should be greate then 5 and smaller than 16", result)
    }

    @Test
    fun isPasswordValid_inputString_validPassword_expected_correctPassword() {
        val result = validatePassword.isPasswordValid("123456789")
        Assert.assertEquals("correct password", result)
    }
}