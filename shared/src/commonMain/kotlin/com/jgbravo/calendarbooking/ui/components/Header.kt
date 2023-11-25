package com.jgbravo.calendarbooking.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.jgbravo.calendarbooking.core.date.Date
import com.jgbravo.calendarbooking.core.date.DatePattern.SPANISH_DATE_PATTERN
import com.jgbravo.calendarbooking.core.date.DateTimeUtil.formatDate
import com.jgbravo.calendarbooking.core.date.DateUtils.WEEK_DAYS
import com.jgbravo.calendarbooking.core.date.DateUtils.daysAfter
import com.jgbravo.calendarbooking.core.date.DateUtils.daysBefore

@Composable
fun HeaderDateInfo(
    daySelected: Date,
    onTodaySelect: () -> Unit,
    onPrevClick: (Date) -> Unit,
    onNextClick: (Date) -> Unit,
) {
    Row {
        Text(
            text = if (daySelected.isToday()) "Today" else {
                daySelected.date.formatDate(SPANISH_DATE_PATTERN)
            },
            modifier = Modifier
                .weight(1f)
                .align(Alignment.CenterVertically)
        )
        IconClickable(
            icon = Icons.Filled.DateRange,
            onClick = onTodaySelect
        )
        IconClickable(
            icon = Icons.Filled.KeyboardArrowLeft,
            onClick = {
                onPrevClick(daySelected.daysBefore(WEEK_DAYS))
            }
        )
        IconClickable(
            icon = Icons.Filled.KeyboardArrowRight,
            onClick = {
                onNextClick(daySelected.daysAfter(WEEK_DAYS))
            }
        )
    }
}