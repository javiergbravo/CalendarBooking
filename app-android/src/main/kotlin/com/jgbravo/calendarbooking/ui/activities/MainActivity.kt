package com.jgbravo.calendarbooking.ui.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.jgbravo.calendarbooking.core.date.Date
import com.jgbravo.calendarbooking.core.date.DateUtils.getWeek
import com.jgbravo.calendarbooking.ui.screens.CalendarScreen

@ExperimentalFoundationApi
@ExperimentalAnimationApi
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            CalendarScreen(
                week = Date.TODAY.getWeek(),
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}
