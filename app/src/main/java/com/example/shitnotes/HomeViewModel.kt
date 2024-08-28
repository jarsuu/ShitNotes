package com.example.shitnotes

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle

@RequiresApi(Build.VERSION_CODES.O)
class HomeViewModel: ViewModel() {
    var currentDate: LocalDate by mutableStateOf(LocalDate.now())
        private set

    fun setDate(date: LocalDate) {
        currentDate = date
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun getPreviousDate(): LocalDate {
        return currentDate.minusDays(1)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun getNextDate(): LocalDate {
        return currentDate.plusDays(1)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun getFormattedHomeDate(currentDate: LocalDate): String {
        val formatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL).format(currentDate)
        return formatter
    }
}