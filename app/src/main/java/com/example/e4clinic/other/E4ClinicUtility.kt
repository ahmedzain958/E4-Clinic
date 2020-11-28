package com.example.e4clinic.other

import org.joda.time.DateTime
import org.joda.time.format.DateTimeFormat
import org.joda.time.format.DateTimeFormatter
import java.text.SimpleDateFormat
import java.util.*


object E4ClinicUtility {
    var monthNameYearFormat = SimpleDateFormat("MMMM, yyyy", Locale.getDefault())
    fun getCurrentMonthYear(dateTime: DateTime? = null): String {
        if (dateTime == null)
            return monthNameYearFormat.format(Calendar.getInstance().time)
        else {
            val monthNameYearFormatter: DateTimeFormatter = DateTimeFormat.forPattern("MMMM, yyyy")
            return dateTime.toString(monthNameYearFormatter)
        }
    }
}