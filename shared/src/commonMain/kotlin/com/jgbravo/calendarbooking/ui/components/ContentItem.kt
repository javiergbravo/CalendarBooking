package com.jgbravo.calendarbooking.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
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

@Composable
fun DaySelector(
    day: Date,
    onClick: (Date) -> Unit
) {
    Card(
        modifier = Modifier
            .padding(4.dp)
            .clickable { onClick(day) },
        colors = CardDefaults.cardColors(
            containerColor = if (day.isSelected) {
                MaterialTheme.colorScheme.primary
            } else {
                MaterialTheme.colorScheme.secondary
            }
        ),
    ) {
        Column(
            modifier = Modifier
                .width(45.dp)
                .height(48.dp)
                .padding(4.dp)
        ) {
            val dayName: String = day.dayName.take(3).lowercase()
                .replaceFirstChar { it.uppercase() }
            Text(
                text = dayName,
                modifier = Modifier.align(Alignment.CenterHorizontally),
                style = MaterialTheme.typography.bodySmall,
                maxLines = 1
            )
            Text(
                text = "${day.dayOfMonth}",
                modifier = Modifier.align(Alignment.CenterHorizontally),
                style = MaterialTheme.typography.bodyMedium,
                maxLines = 1
            )
        }
    }
}