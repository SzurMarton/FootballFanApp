package com.footballfan.domain.models.football

import com.footballfan.data.network.football.models.Stat
import com.footballfan.data.network.football.models.StatsData

data class DomainStatsData(val stats: List<DomainStat>?)

data class DomainStat(val teamID: Int?, val statistics: List<StatObject>?)

data class StatObject(val type: String?,val value:String?)