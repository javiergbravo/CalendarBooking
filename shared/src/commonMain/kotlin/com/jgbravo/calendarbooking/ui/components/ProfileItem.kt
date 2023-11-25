package com.jgbravo.calendarbooking.ui.components

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.jgbravo.calendarbooking.ui.models.ProfileUi

@Composable
fun ProfileItem(
    profile: ProfileUi,
    onClick: (profile: ProfileUi) -> Unit
) {
    Card(
        modifier = Modifier
            .clip(shape = RoundedCornerShape(0.dp))
            .border(
                width = 1.dp,
                color = Color.Black,
                shape = MaterialTheme.shapes.extraSmall
            )
            .height(56.dp)
            .aspectRatio(1f)
            .clickable { onClick(profile) },
        colors = CardDefaults.cardColors(containerColor = Color.Cyan),
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = profile.name.take(2),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.titleLarge,
                maxLines = 1
            )
        }
    }
}