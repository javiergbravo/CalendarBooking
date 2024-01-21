package com.jgbravo.calendarbooking.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.jgbravo.calendarbooking.core.date.Date
import com.jgbravo.calendarbooking.core.date.DateUtils.getWeek
import com.jgbravo.calendarbooking.ui.components.WeekCalendar
import com.jgbravo.calendarbooking.ui.components.WorkoutItem
import com.jgbravo.calendarbooking.ui.models.Schedule

@Composable
fun CalendarScreen(
    week: Schedule
) {
    var calendarUiModel by remember { mutableStateOf(week.calendarUi) }

    Scaffold(
        modifier = Modifier.fillMaxSize().background(color = Color.White),
        topBar = {
            WeekCalendar(
                modifier = Modifier.fillMaxWidth(),
                week = calendarUiModel,
                onTodaySelect = {
                    calendarUiModel = Date.TODAY.getWeek()
                },
                onPrevClick = { startDate ->
                    calendarUiModel = startDate.getWeek()
                },
                onNextClick = { endDate ->
                    calendarUiModel = endDate.getWeek()
                },
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
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .padding(innerPadding)
                .padding(horizontal = 16.dp)
                .fillMaxSize()
        ) {
            val workoutOfDaySelected = week.getWorkoutOfDateSelected(calendarUiModel.selectedDate)
            items(workoutOfDaySelected) { workout ->
                WorkoutItem(workout = workout)
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}