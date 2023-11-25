package com.jgbravo.calendarbooking.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.jgbravo.calendarbooking.core.date.Date
import com.jgbravo.calendarbooking.ui.models.CalendarUi

@Composable
fun WeekCalendar(
    week: CalendarUi,
    onDateClick: (Date) -> Unit,
) {
    LazyRow(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
    ) {
        items(week.visibleDates) { day ->
            DaySelector(
                day = day,
                onClick = onDateClick
            )
        }
    }
}