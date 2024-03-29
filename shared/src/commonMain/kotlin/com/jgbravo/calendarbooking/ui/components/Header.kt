package com.jgbravo.calendarbooking.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.jgbravo.calendarbooking.core.date.Date
import com.jgbravo.calendarbooking.core.date.DateUtils.WEEK_DAYS
import com.jgbravo.calendarbooking.core.date.DateUtils.daysAfter
import com.jgbravo.calendarbooking.core.date.DateUtils.daysBefore
import com.jgbravo.calendarbooking.core.date.DateUtils.info

@Composable
fun HeaderDateInfo(
    daySelected: Date,
    onTodaySelect: () -> Unit,
    onPrevClick: (Date) -> Unit,
    onNextClick: (Date) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(modifier = modifier.padding(horizontal = 16.dp)) {
        Text(
            text = if (daySelected.isToday()) {
                "Today"
            } else {
                daySelected.info()
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