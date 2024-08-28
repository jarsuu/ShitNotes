package com.example.shitnotes

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle

@RequiresApi(Build.VERSION_CODES.O)
class DateManager {
    private var _currentDate by mutableStateOf(LocalDate.now())

    @RequiresApi(Build.VERSION_CODES.O)
    fun getCurrentDate(): LocalDate {
        return LocalDate.now()
    }

    fun setCurrentDate(newDate: LocalDate) {
        _currentDate = newDate
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