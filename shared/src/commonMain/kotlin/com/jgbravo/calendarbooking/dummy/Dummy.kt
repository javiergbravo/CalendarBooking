package com.jgbravo.calendarbooking.dummy

import com.jgbravo.calendarbooking.core.date.Date
import com.jgbravo.calendarbooking.core.date.DateUtils.getWeek
import com.jgbravo.calendarbooking.ui.models.CalendarUi
import com.jgbravo.calendarbooking.ui.models.ProfileUi
import com.jgbravo.calendarbooking.ui.models.Schedule
import com.jgbravo.calendarbooking.ui.models.WorkoutUi
import kotlinx.datetime.LocalDateTime

object Dummy {

    private const val profileImage = "https://avatars.githubusercontent.com/u/1024021"

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
        image = profileImage
    )

    private val profileAgus = ProfileUi(
        id = "2",
        name = "Agus",
        image = profileImage
    )

    private val profileMarta = ProfileUi(
        id = "3",
        name = "Marta",
        image = profileImage
    )

    private val profileSara = ProfileUi(
        id = "4",
        name = "Sara",
        image = profileImage
    )

    private val profileSergio = ProfileUi(
        id = "5",
        name = "Sergio",
        image = profileImage
    )

    private val profileDavid = ProfileUi(
        id = "6",
        name = "David",
        image = profileImage
    )

    private val profileAlex = ProfileUi(
        id = "7",
        name = "Alex",
        image = profileImage
    )

    private val profileJorge = ProfileUi(
        id = "8",
        name = "Jorge",
        image = profileImage
    )

    private val profileEdu = ProfileUi(
        id = "9",
        name = "Edu",
        image = profileImage
    )

    private val profileSafa = ProfileUi(
        id = "10",
        name = "Safa",
        image = profileImage
    )
}