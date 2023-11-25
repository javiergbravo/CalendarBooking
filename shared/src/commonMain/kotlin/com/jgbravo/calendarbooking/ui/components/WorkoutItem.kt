package com.jgbravo.calendarbooking.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.jgbravo.calendarbooking.ui.models.WorkoutUi

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun WorkoutItem(workout: WorkoutUi) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        WorkoutHeader(workout = workout)
        Spacer(modifier = Modifier.padding(4.dp))
        FlowRow(
            horizontalArrangement = Arrangement.spacedBy(4.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp),
        ) {
            workout.bookings.forEach { profile ->
                ProfileItem(
                    profile = profile,
                    onClick = { /*TODO*/ }
                )
            }
        }
    }
}

@Composable
fun WorkoutHeader(workout: WorkoutUi) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = workout.name,
            style = MaterialTheme.typography.titleMedium
        )
        Text(
            text = "${workout.startTime}h - ${workout.endTime}h",
            style = MaterialTheme.typography.titleMedium
        )
    }
}
