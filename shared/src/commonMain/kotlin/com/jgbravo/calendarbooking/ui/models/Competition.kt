package com.jgbravo.calendarbooking.ui.models

import kotlinx.datetime.LocalDate

data class Competition(
    val name: String,
    val date: LocalDate,
    val category: CompetitionCategory,
    val type: CompetitionType,
    val positionResult: Int?,
)

data class Competitor(
    val isActive: Boolean,
    val actualCategory: String,
    val honors: List<Competition>,
)

enum class CompetitionCategory {
    ELITE, RX, INTERMEDIATE, SCALED, BEGINNER
}

sealed class CompetitionType(val partners: List<ProfileUi>) {
    data object Solo : CompetitionType(partners = emptyList())
    data class Duo(val members: List<ProfileUi>) : CompetitionType(partners = members)
    data class Trio(val members: List<ProfileUi>) : CompetitionType(partners = members)
    data class Team(val members: List<ProfileUi>) : CompetitionType(partners = members)
}