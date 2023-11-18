package com.jgbravo.calendarbooking.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.jgbravo.calendarbooking.core.date.Date
import com.jgbravo.calendarbooking.core.date.DatePattern.SPANISH_DATE_PATTERN
import com.jgbravo.calendarbooking.core.date.DateTimeUtil.formatDate

@Composable
fun HeaderDateInfo(daySelected: Date) {
    Row {
        Text(
            text = if (daySelected.isToday()) "Today" else {
                daySelected.date.formatDate(SPANISH_DATE_PATTERN)
            },
            modifier = Modifier
                .weight(1f)
                .align(Alignment.CenterVertically)
        )
        IconButton(onClick = { }) {
            Icon(
                imageVector = Icons.Filled.KeyboardArrowLeft,
                contentDescription = "Previous"
            )
        }
        IconButton(onClick = { }) {
            Icon(
                imageVector = Icons.Filled.KeyboardArrowRight,
                contentDescription = "Next"
            )
        }
    }
}