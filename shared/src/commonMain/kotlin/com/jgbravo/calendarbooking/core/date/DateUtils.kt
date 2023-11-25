package com.jgbravo.calendarbooking.core.date

import com.jgbravo.calendarbooking.ui.models.CalendarUiModel
import kotlinx.datetime.DateTimeUnit
import kotlinx.datetime.DayOfWeek
import kotlinx.datetime.LocalDate
import kotlinx.datetime.minus
import kotlinx.datetime.plus

object DateUtils {

    const val WEEK_DAYS = 7

    fun Date.getWeek(): CalendarUiModel {
        val days = mutableListOf<LocalDate>()
        val firstWeekDay = date.daysShift(-DayOfWeek.values().indexOf(date.dayOfWeek))
        for (i in 0 until DayOfWeek.values().count()) {
            days.add(firstWeekDay.daysShift(i))
        }
        return CalendarUiModel(
            selectedDate = this,
            visibleDates = days.toList().map { Date(it, it == date) }
        )
    }

    fun Date.daysAfter(days: Int): Date {
        val newDate = date.plus(DateTimeUnit.DayBased(days))
        return Date(newDate, newDate == DateTimeUtil.now().date)
    }

    fun Date.daysBefore(days: Int): Date {
        val newDate = date.minus(DateTimeUnit.DayBased(days))
        return Date(newDate, newDate == DateTimeUtil.now().date)
    }

    private fun LocalDate.daysShift(days: Int): LocalDate = when {
        days < 0 -> {
            minus(DateTimeUnit.DayBased(-days))
        }
        days > 0 -> {
            plus(DateTimeUnit.DayBased(days))
        }
        else -> this
    }
}