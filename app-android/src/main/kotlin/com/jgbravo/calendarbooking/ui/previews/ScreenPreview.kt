package com.jgbravo.calendarbooking.ui.previews

import android.content.res.Configuration
import androidx.compose.ui.tooling.preview.Preview

@Preview(
    name = "Light mode",
    uiMode = Configuration.UI_MODE_NIGHT_NO,
    showSystemUi = true,
    backgroundColor = 0xFFFFFFFF
)
@Preview(
    name = "Dark mode",
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showSystemUi = true,
    backgroundColor = 0xFF000000
)
annotation class ScreenPreview