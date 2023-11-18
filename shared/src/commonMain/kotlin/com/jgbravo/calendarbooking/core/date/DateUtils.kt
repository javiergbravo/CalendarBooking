package com.jgbravo.calendarbooking.core.date

import kotlinx.datetime.DateTimeUnit
import kotlinx.datetime.DayOfWeek
import kotlinx.datetime.LocalDate
import kotlinx.datetime.minus
import kotlinx.datetime.plus

object DateUtils {

    fun getCurrentWeek(): List<Date> {
        val today = DateTimeUtil.now().date
        val days = mutableListOf<LocalDate>()
        val firstWeekDay = today.daysShift(-DayOfWeek.values().indexOf(today.dayOfWeek))
        for (i in 0 until DayOfWeek.values().count()) {
            days.add(firstWeekDay.daysShift(i))
        }
        return days.toList().map { Date(it, it == today) }
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