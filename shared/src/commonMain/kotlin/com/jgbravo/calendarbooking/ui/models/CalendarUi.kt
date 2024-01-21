package com.jgbravo.calendarbooking.ui.models

import com.jgbravo.calendarbooking.core.date.Date

data class CalendarUi(
    val selectedDate: Date = Date.TODAY,
    val visibleDates: List<Date>
) {
    val startDate: Date = visibleDates.first()
    val endDate: Date = visibleDates.last()
}