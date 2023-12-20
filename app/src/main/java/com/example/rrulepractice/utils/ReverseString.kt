package com.example.rrulepractice.utils

import java.lang.IllegalArgumentException

class ReverseString {

    fun reverseString(name: String): String {

        if(name.isEmpty()) {
            throw IllegalArgumentException("")
        }

        val nameArray = name.toCharArray()
        val builder = StringBuilder(nameArray.size)

        for (index in nameArray.size -1 downTo 0) {
            builder.append(nameArray[index])
        }
        return builder.toString()
    }
}