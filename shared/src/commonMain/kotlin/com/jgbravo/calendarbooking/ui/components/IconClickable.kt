package com.jgbravo.calendarbooking.ui.components

import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector

@Composable
fun IconClickable(
    icon: ImageVector,
    onClick: () -> Unit,
    contentDescription: String = "Icon button clickable $icon"
) {
    IconButton(onClick = onClick) {
        Icon(
            imageVector = icon,
            contentDescription = contentDescription
        )
    }
}