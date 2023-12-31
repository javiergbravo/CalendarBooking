package com.jgbravo.calendarbooking.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.jgbravo.calendarbooking.data.Platform
import com.jgbravo.calendarbooking.ui.theme.AppTheme

@Composable
fun MainScreen() {
    val platform = Platform().platform
    val greeting = "Hello, $platform"

    AppTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Box(modifier = Modifier.fillMaxSize()) {
                Text(
                    modifier = Modifier.align(Alignment.Center),
                    text = greeting,
                    color = MaterialTheme.colorScheme.onSurface
                )
            }
        }
    }
}
