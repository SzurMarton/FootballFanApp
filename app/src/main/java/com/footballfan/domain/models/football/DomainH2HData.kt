package com.footballfan.domain.models.football

import com.footballfan.data.network.football.models.FixtureData

data class DomainH2HData(val h2hfixtures: List<DomainH2HFixture>?)

data class DomainH2HFixture(
        val fixtureID: Int?,
        val date: String?,
        val homeTeamID: Int?,
        val awayTeamId: Int?,
        val homeTeamLogo: String?,
        val awayTeamLogo: String?,
        val homeTeamName: String?,
        val awayTeamName: String?,
        val homeGoals: Int?,
        val awayGoals: Int?,
        val homeWinner: Boolean?,
        val awayWinner: Boolean?
)