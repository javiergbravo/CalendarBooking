package com.jgbravo.calendarbooking.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.jgbravo.calendarbooking.core.date.Date
import com.jgbravo.calendarbooking.ui.models.CalendarUiModel

@Composable
fun WeekCalendar(
    week: CalendarUiModel,
    onDateClick: (Date) -> Unit,
) {
    LazyRow(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
    ) {
        items(
            count = week.visibleDates.size,
            key = { index -> week.visibleDates[index].dayOfMonth }
        ) { index ->
            val day = week.visibleDates[index]
            DaySelector(
                day = day,
                onClick = onDateClick
            )
        }
    }
}