package com.jgbravo.calendarbooking.ui.previews

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.jgbravo.calendarbooking.core.date.Date
import com.jgbravo.calendarbooking.core.date.DateUtils.getWeek
import com.jgbravo.calendarbooking.dummy.Dummy
import com.jgbravo.calendarbooking.ui.components.HeaderDateInfo
import com.jgbravo.calendarbooking.ui.theme.AppTheme

@Preview
@Composable
fun HeaderDateInfoPreview() {
    val today = Date(
        date = kotlinx.datetime.LocalDate(2024, 1, 1),
        isSelected = true
    )
    var calendarUiModel = Dummy.getSchedule(today).calendarUi
    AppTheme {
        HeaderDateInfo(
            daySelected = calendarUiModel.selectedDate,
            onTodaySelect = {
                calendarUiModel = Date.TODAY.getWeek()
            },
            onPrevClick = { startDate ->
                calendarUiModel = startDate.getWeek()
            },
            onNextClick = { endDate ->
                calendarUiModel = endDate.getWeek()
            }
        )
    }
}