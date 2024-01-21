package com.jgbravo.calendarbooking.ui.models

import com.jgbravo.calendarbooking.core.date.Date

data class Schedule(
    val calendarUi: CalendarUi,
    val workouts: List<WorkoutUi>
) {
    fun getWorkoutOfDateSelected(date: Date): List<WorkoutUi> {
        return workouts.filter { it.dateTime.date == date.date }
    }
}