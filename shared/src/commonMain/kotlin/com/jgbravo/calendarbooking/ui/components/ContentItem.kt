package com.jgbravo.calendarbooking.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.jgbravo.calendarbooking.core.date.Date
import com.jgbravo.calendarbooking.core.string.abbreviate
import com.jgbravo.calendarbooking.ui.theme.Gray

@Composable
fun DaySelector(
    day: Date,
    onClick: (Date) -> Unit
) {
    Card(
        modifier = Modifier
            .clickable { onClick(day) }
            .padding(4.dp)
            .width(45.dp),
        colors = CardDefaults.cardColors(
            containerColor = if (day.isSelected) {
                MaterialTheme.colorScheme.primary
            } else {
                Gray
            }
        ),
    ) {
        Text(
            text = day.dayName.abbreviate(),
            modifier = Modifier
                .padding(top = 4.dp)
                .align(Alignment.CenterHorizontally),
            style = MaterialTheme.typography.bodySmall,
            maxLines = 1
        )
        Text(
            text = "${day.date.dayOfMonth}",
            modifier = Modifier
                .padding(top = 4.dp)
                .align(Alignment.CenterHorizontally),
            style = MaterialTheme.typography.bodyMedium,
            maxLines = 1
        )
    }
}