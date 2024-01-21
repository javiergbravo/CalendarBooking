package com.jgbravo.calendarbooking.ui.models

import com.jgbravo.calendarbooking.core.date.DateTimeUtil
import kotlinx.datetime.LocalDate

data class ProfileUi(
    val id: String,
    val name: String,
    val image: String?,
)

data class ProfileDetailsUi(
    val id: String,
    val name: String,
    val affiliateSince: LocalDate,
    val image: String? = null,
    val birthday: LocalDate? = null,
    val gender: String? = null,
    val height: Int? = null,
    val weight: Int? = null,
    val competitor: Competitor? = null,
) {
    val age: Int?
        get() = birthday?.let { DateTimeUtil.now().date.year - it.year }
}