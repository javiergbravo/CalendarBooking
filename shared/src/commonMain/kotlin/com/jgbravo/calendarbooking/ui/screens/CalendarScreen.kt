package com.jgbravo.calendarbooking.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.jgbravo.calendarbooking.core.date.Date
import com.jgbravo.calendarbooking.core.date.DateUtils.getWeek
import com.jgbravo.calendarbooking.ui.components.HeaderDateInfo
import com.jgbravo.calendarbooking.ui.components.WeekCalendar
import com.jgbravo.calendarbooking.ui.models.CalendarUiModel

@Composable
fun CalendarScreen(
    week: CalendarUiModel,
    modifier: Modifier = Modifier
) {
    var calendarUiModel by remember { mutableStateOf(week) }

    Column(modifier = modifier.fillMaxSize()) {
        HeaderDateInfo(
            daySelected = calendarUiModel.selectedDate,
            onTodaySelect = {
                calendarUiModel = Date.TODAY.getWeek()
            },
            onPrevClick = { startDate ->
                calendarUiModel = startDate.getWeek()
            },
            onNextClick = { endDate ->
                calendarUiModel = endDate.getWeek()
            }
        )
        WeekCalendar(
            week = calendarUiModel,
            onDateClick = { date ->
                calendarUiModel = calendarUiModel.copy(
                    selectedDate = date,
                    visibleDates = calendarUiModel.visibleDates.map {
                        it.copy(isSelected = it == date)
                    }
                )
            }
        )
    }
}