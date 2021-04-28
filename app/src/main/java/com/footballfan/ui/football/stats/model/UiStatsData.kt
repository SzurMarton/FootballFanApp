package com.footballfan.ui.football.stats.model

import com.footballfan.domain.models.football.StatObject

data class UiStatsData(
    val homeTeamStats: UiStat,
    val awayTeamStats: UiStat
)

data class UiStat(val teamID: Int, val statistics: List<UiStatObject>)

data class UiStatObject(val type: String,val value:String)