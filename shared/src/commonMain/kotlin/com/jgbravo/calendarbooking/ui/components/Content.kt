package com.jgbravo.calendarbooking.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.jgbravo.calendarbooking.core.date.Date
import com.jgbravo.calendarbooking.ui.models.CalendarUi

@Composable
fun WeekCalendar(
    week: CalendarUi,
    onTodaySelect: () -> Unit,
    onPrevClick: (Date) -> Unit,
    onNextClick: (Date) -> Unit,
    onDateClick: (Date) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        HeaderDateInfo(
            daySelected = week.selectedDate,
            onTodaySelect = onTodaySelect,
            onPrevClick = onPrevClick,
            onNextClick = onNextClick
        )
        LazyRow(
            modifier = modifier.fillMaxWidth().padding(horizontal = 8.dp),
            horizontalArrangement = Arrangement.Absolute.SpaceBetween,
        ) {
            items(
                items = week.visibleDates,
                key = { it.date.toString() }
            ) { day ->
                DaySelector(
                    day = day,
                    onClick = onDateClick
                )
            }
        }
    }
}