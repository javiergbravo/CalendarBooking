package com.jgbravo.calendarbooking.dummy

import com.jgbravo.calendarbooking.core.date.Date
import com.jgbravo.calendarbooking.core.date.DateUtils.getWeek
import com.jgbravo.calendarbooking.ui.models.CalendarUi
import com.jgbravo.calendarbooking.ui.models.ProfileUi
import com.jgbravo.calendarbooking.ui.models.Schedule
import com.jgbravo.calendarbooking.ui.models.WorkoutUi
import kotlinx.datetime.LocalDateTime

object Dummy {

    private fun getImageUrl(id: Int = (237..260).random()): String {
        return "https://picsum.photos/id/$id/200/300"
    }

    fun getSchedule(date: Date): Schedule {
        val weekCalendar = CalendarUi(
            selectedDate = date,
            visibleDates = date.getWeek().visibleDates
        )
        return Schedule(
            calendarUi = CalendarUi(
                selectedDate = Date.TODAY,
                visibleDates = Date.TODAY.getWeek().visibleDates
            ),
            workouts = mutableListOf<WorkoutUi>().apply {
                weekCalendar.visibleDates.map { date ->
                    getDummyDayWorkouts(date)
                }.forEach { workouts ->
                    addAll(workouts)
                }
            }.toList()
        )
    }

    fun getDummyDayWorkouts(day: Date): List<WorkoutUi> {
        return List(8) {
            WorkoutUi(
                name = "WOD",
                dateTime = LocalDateTime(
                    year = day.date.year,
                    monthNumber = day.date.monthNumber,
                    dayOfMonth = day.date.dayOfMonth,
                    hour = 8 + it,
                    minute = 0
                ),
                durationInMin = 60,
                maxBookings = 10,
                bookings = getDummyProfiles().take(it + 1)
            )
        }
    }

    fun getDummyProfiles(): List<ProfileUi> {
        return listOf(
            profileJavi,
            profileAgus,
            profileMarta,
            profileSara,
            profileSergio,
            profileDavid,
            profileAlex,
            profileJorge,
            profileEdu,
            profileSafa
        )
    }

    private val profileJavi = ProfileUi(
        id = "1",
        name = "Javi",
        image = getImageUrl(237)
    )

    private val profileAgus = ProfileUi(
        id = "2",
        name = "Agus",
        image = getImageUrl()
    )

    private val profileMarta = ProfileUi(
        id = "3",
        name = "Marta",
        image = getImageUrl()
    )

    private val profileSara = ProfileUi(
        id = "4",
        name = "Sara",
        image = getImageUrl()
    )

    private val profileSergio = ProfileUi(
        id = "5",
        name = "Sergio",
        image = getImageUrl()
    )

    private val profileDavid = ProfileUi(
        id = "6",
        name = "David",
        image = getImageUrl()
    )

    private val profileAlex = ProfileUi(
        id = "7",
        name = "Alex",
        image = getImageUrl()
    )

    private val profileJorge = ProfileUi(
        id = "8",
        name = "Jorge",
        image = getImageUrl()
    )

    private val profileEdu = ProfileUi(
        id = "9",
        name = "Edu",
        image = getImageUrl()
    )

    private val profileSafa = ProfileUi(
        id = "10",
        name = "Safa",
        image = getImageUrl()
    )
}