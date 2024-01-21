package com.jgbravo.calendarbooking.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun <T> NonLazyGrid(
    columns: Int,
    items: List<T>,
    modifier: Modifier = Modifier,
    spaceBetweenItems: Dp = 0.dp,
    content: @Composable (item: T) -> Unit
) {
    val itemCount = items.size
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(spaceBetweenItems)
    ) {
        var rows = (itemCount / columns)
        if (itemCount.mod(columns) > 0) {
            rows += 1
        }

        for (rowId in 0 until rows) {
            val firstIndex = rowId * columns

            Row(
                horizontalArrangement = Arrangement.spacedBy(spaceBetweenItems),
            ) {
                for (columnId in 0 until columns) {
                    val index = firstIndex + columnId
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f)
                    ) {
                        if (index < itemCount) {
                            content(items[index])
                        }
                    }
                }
            }
        }
    }
}