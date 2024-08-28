package com.example.shitnotes

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle

class DateManager {
    @RequiresApi(Build.VERSION_CODES.O)
    fun getCurrentDate(): LocalDate {
        return LocalDate.now()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun getNextDate(currentDate: LocalDate): LocalDate {
        return currentDate.plusDays(1)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun getPreviousDate(currentDate: LocalDate): LocalDate {
        return currentDate.minusDays(1)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun getFormattedHomeDate(currentDate: LocalDate): String {
        val formatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL).format(currentDate)
        return formatter
    }
}