package com.footballfan.ui.football.headtohead.model

import com.footballfan.domain.models.football.DomainH2HFixture

data class UiHeadToHeadData (val h2hfixtures: List<UiH2HFixture>)

data class UiH2HFixture(
        val fixtureID: Int,
        val date: String,
        val homeTeamID: Int,
        val awayTeamId: Int,
        val homeTeamLogo: String,
        val awayTeamLogo: String,
        val homeTeamName: String,
        val awayTeamName: String,
        val homeGoals: String,
        val awayGoals: String,
        val homeWinner: Boolean,
        val awayWinner: Boolean
)