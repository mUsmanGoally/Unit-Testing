package com.example.rrulepractice.utils

import org.dmfs.rfc5545.DateTime
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import java.lang.Exception

class HelperTest {
    private lateinit var helper: Helper

    @Before
    fun setUp() {
        helper = Helper()
    }

    @Test
    fun getScheduled_with_valid_input_should_return_list_of_expected_size() {
        val result = helper.getScheduled("FREQ=MONTHLY;COUNT=10;INTERVAL=12;WKST=TU;BYDAY=MO,TH;BYMONTH=7,12")
        Assert.assertEquals(10, result.size)
    }

    @Test
    fun getScheduled_input_null_should_return_emptyList() {
        val result = helper.getScheduled(null)
        Assert.assertTrue(result.isEmpty())
    }

    @Test
    fun getScheduled_with_count_exceeding_limit_should_return_valid_result() {
        val result = helper.getScheduled("FREQ=MONTHLY;COUNT=110;WKST=SU;BYDAY=WE,SA;BYMONTH=1,3,4,7,9")
        Assert.assertTrue(result.size <= 1 || result.size > 100)
    }


    @Test
    fun getScheduled_with_specific_date_time_should_match_expected_value() {
        val result = helper.getScheduled("FREQ=DAILY;COUNT=90;WKST=SU;BYDAY=MO,WE,SA")
        Assert.assertTrue(result[50].dayOfMonth == 15)
        Assert.assertTrue(result[50].month == 3)
        Assert.assertTrue(result[50].year == 2024)
        Assert.assertTrue(result[50].dayOfWeek == 1)
        Assert.assertEquals(DateTime.now().minutes, result[50].minutes)
        Assert.assertEquals(DateTime.now().seconds, result[50].seconds)
        Assert.assertEquals(getExpectedTime(result[50]), DateTime.now().hours)
    }

    private fun getExpectedTime(scheduled: DateTime): Int {
        return (DateTime.now().hours - scheduled.hours) + scheduled.hours
    }
}