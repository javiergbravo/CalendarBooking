package com.jgbravo.calendarbooking.ui

import androidx.compose.ui.window.ComposeUIViewController
import com.jgbravo.calendarbooking.ui.screens.MainScreen
import kotlin.experimental.ExperimentalObjCName

@OptIn(ExperimentalObjCName::class)
@ObjCName("MainScreen")
fun MainViewController() = ComposeUIViewController { MainScreen() }