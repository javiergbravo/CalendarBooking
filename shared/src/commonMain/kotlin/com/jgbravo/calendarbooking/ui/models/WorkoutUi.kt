package com.jgbravo.calendarbooking.ui.models

import com.jgbravo.calendarbooking.core.date.TimeUtils.formatTime
import kotlinx.datetime.LocalDateTime

data class WorkoutUi(
    val name: String,
    val dateTime: LocalDateTime,
    val durationInMin: Int,
    val maxBookings: Int,
    val bookings: List<ProfileUi>
) {
    val startTime: String = dateTime.formatTime()
    val endTime: String = dateTime.apply { minute.plus(durationInMin) }.formatTime()
}