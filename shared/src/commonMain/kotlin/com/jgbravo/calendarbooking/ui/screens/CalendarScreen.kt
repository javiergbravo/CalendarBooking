package com.jgbravo.calendarbooking.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.jgbravo.calendarbooking.ui.components.HeaderDateInfo
import com.jgbravo.calendarbooking.ui.components.WeekContent
import com.jgbravo.calendarbooking.ui.models.CalendarUiModel

@Composable
fun CalendarScreen(
    week: CalendarUiModel,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.fillMaxSize()) {
        HeaderDateInfo(daySelected = week.selectedDate)
        WeekContent(week = week)
    }
}