package com.footballfan.ui.football.fixturelist.model

data class FixtureListData(val fixtures: List<FixtureListUiData>?)

data class FixtureListUiData(
        val fixtureID:Int,
        val homeTeamName:String,
        val homeTeamLogo:String,
        val homeTeamWinner:Boolean,
        val awayTeamName:String,
        val awayTeamLogo:String,
        val awayTeamWinner:Boolean,
        val homeGoals:Int,
        val awayGoals:Int,
        val leagueRound:String
)