package com.footballfan.data.network.football.models

data class FixtureStatsResult(val get: String?,val parameters: ParamsStats?, val errors: List<Error>?,
                         val results: Int?,val paging: Paging?,val response: List<StatsData>?)

data class ParamsStats(val fixture: String?)

data class StatsData(val team: TeamsInfo,val statistics: List<Stat>?)

data class TeamsInfo(val id: Int?,val name: String?,val logo: String?)

data class Stat(val type: String?,val value:String?)