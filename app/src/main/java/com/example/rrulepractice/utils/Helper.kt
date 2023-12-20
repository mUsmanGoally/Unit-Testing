package com.example.rrulepractice.utils

import org.dmfs.rfc5545.DateTime
import org.dmfs.rfc5545.recur.RecurrenceRule
import org.dmfs.rfc5545.recur.RecurrenceRuleIterator
import java.util.Calendar
import java.util.Locale
import java.util.TimeZone

class Helper {
    fun getScheduled(input: String?): ArrayList<DateTime> {
        val instancesList = ArrayList<DateTime>()

        input?.let {
            val cal: Calendar = Calendar.getInstance(TimeZone.getDefault(), Locale.getDefault())
            val start: DateTime = DateTime.now()
            val rule = RecurrenceRule(input)
            val iterator: RecurrenceRuleIterator = rule.iterator(start)

            var maxInstances = 100
            while (iterator.hasNext() && (!rule.isInfinite || maxInstances-- > 0)) {
                val nextInstance: DateTime = iterator.nextDateTime()

                cal.set(Calendar.DATE, nextInstance.dayOfMonth)
                cal.set(Calendar.MONTH, nextInstance.month)
                cal.set(Calendar.YEAR, nextInstance.year)

                cal.set(Calendar.HOUR_OF_DAY, nextInstance.hours)
                cal.set(Calendar.MINUTE, nextInstance.minutes)
                cal.set(Calendar.SECOND, 0)

                instancesList.add(nextInstance)
            }
        }

        return instancesList
    }

}