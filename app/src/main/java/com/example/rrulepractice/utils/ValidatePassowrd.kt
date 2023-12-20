package com.example.rrulepractice.utils

class ValidatePassword {
    fun isPasswordValid(password: String): String {
        return when {
            password.isEmpty() -> "password is empty"
            password.length !in (5 .. 15) -> "password should be greate then 5 and smaller than 16"
            password.length in 6..15 && password.isNotEmpty() -> "correct password"
            else -> "invalid password"
        }
    }
}