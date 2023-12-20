package com.example.rrulepractice.utils

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.google.gson.JsonSyntaxException
import org.junit.Assert.*

import org.junit.After
import org.junit.Before
import org.junit.Test
import java.io.FileNotFoundException

class QuoteManagerTest {
    private lateinit var quoteManager: QuoteManager

    @Before
    fun setUp() {
        quoteManager = QuoteManager()
    }

    @Test(expected = FileNotFoundException::class )
    fun testPopulateQuoteFromAssets_emptyFileName_expected_Exception() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        quoteManager.populateQuoteFromAssets(context, "")
    }

    @Test(expected = JsonSyntaxException::class )
    fun testPopulateQuoteFromAssets_invalidJson_expected_Exception() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        quoteManager.populateQuoteFromAssets(context, "malformed.json")
    }

    @Test
    fun testPopulateQuoteFromAssets_validJson_expected_Count() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        quoteManager.populateQuoteFromAssets(context, "quotes.json")
        assertEquals(102, quoteManager.quoteList.size)
    }

    @Test
    fun testPreviousQuote_expected_correctQuote() {
        quoteManager.populateQuotes(arrayOf(
            Quote("this is first quote", "1"),
            Quote("this is second quote", "2"),
            Quote("this is third quote", "3")
        ))

        val quote = quoteManager.getPreviousQuote()
        assertEquals("1", quote.author)
    }

    @Test
    fun testNextQuote_expected_correctQuote() {
        quoteManager.populateQuotes(arrayOf(
            Quote("this is first quote", "1"),
            Quote("this is second quote", "2"),
            Quote("this is third quote", "3")
        ))

        val quote = quoteManager.getNextQuote()
        assertEquals("2", quote.author)
    }
}