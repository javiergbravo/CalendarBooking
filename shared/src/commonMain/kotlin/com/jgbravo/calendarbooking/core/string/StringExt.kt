package com.jgbravo.calendarbooking.core.string

fun String.abbreviate(charsToShow: Int = 3): String {
    return take(charsToShow).lowercase().replaceFirstChar { it.uppercase() }
}