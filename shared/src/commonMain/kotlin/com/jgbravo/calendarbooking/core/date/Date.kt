package com.jgbravo.calendarbooking.core.date

import kotlinx.datetime.LocalDate

data class Date(
    val date: LocalDate,
    val isSelected: Boolean,
) {
    val dayName: String = date.dayOfWeek.name
    val dayOfMonth: Int = date.dayOfMonth

    fun isToday(): Boolean = date == DateTimeUtil.now().date

    companion object {
        val TODAY = Date(date = DateTimeUtil.now().date, isSelected = true)
    }
}