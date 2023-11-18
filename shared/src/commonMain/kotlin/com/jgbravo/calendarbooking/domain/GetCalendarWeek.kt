package com.jgbravo.calendarbooking.domain

import com.jgbravo.calendarbooking.core.date.DateUtils
import com.jgbravo.calendarbooking.ui.models.CalendarUiModel

object GetCalendarWeek {

    operator fun invoke(): CalendarUiModel {
        return CalendarUiModel(
            visibleDates = DateUtils.getCurrentWeek()
        )
    }
}