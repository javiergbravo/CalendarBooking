package com.jgbravo.calendarbooking.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.jgbravo.calendarbooking.ui.models.ProfileUi
import io.kamel.image.KamelImage
import io.kamel.image.asyncPainterResource

@Composable
fun ProfileItem(
    profile: ProfileUi,
    onClick: (profile: ProfileUi) -> Unit
) {
    var isImageLoaded by remember { mutableStateOf(true) }

    Card(
        modifier = Modifier
            .height(56.dp)
            .aspectRatio(1f)
            .clickable { onClick(profile) },
        colors = CardDefaults.cardColors(containerColor = Color.Cyan),
        border = if (isImageLoaded) null else BorderStroke(1.dp, Color.Black),
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            if (profile.image == null) {
                Text(
                    text = profile.name.take(2),
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.titleLarge,
                    maxLines = 1
                )
            } else {
                KamelImage(
                    resource = asyncPainterResource(profile.image),
                    contentDescription = "Profile image",
                    contentScale = ContentScale.FillWidth,
                    onFailure = {
                        isImageLoaded = false
                        Text(
                            text = profile.name.take(2),
                            textAlign = TextAlign.Center,
                            style = MaterialTheme.typography.titleLarge,
                            maxLines = 1
                        )
                    }
                )
            }
        }
    }
}