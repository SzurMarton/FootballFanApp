package com.footballfan.ui.football.leaguestandings.model

//TODO maybe better with only one list
data class UiStandingsData(
        val leagueID: Int,
        val leagueLogo: String,
        val leagueName: String,
        val season: Int,
        val standingsAll: List<UiStandingsAll>,
        val standingsHome: List<UiStandingsHome>,
        val standingsAway: List<UiStandingsAway>
)

data class UiStandingsAll(
        val teamID: Int?,
        val teamLogo: String?,
        val teamName: String?,
        val points: Int,
        val goalDiff:Int,
        val drawAllGames: Int,
        val goalsAllGamesFor: Int,
        val goalsAllGamesAgainst: Int,
        val loseAllGames: Int,
        val playedAllGames: Int,
        val winAllGames: Int
)

data class UiStandingsHome(
        val teamID: Int?,
        val teamLogo: String?,
        val teamName: String?,
        val homeGoalDiff: Int,
        val homePoints:Int,
        val drawHomeGames: Int,
        val goalsHomeGamesFor: Int,
        val goalsHomeGamesAgainst: Int,
        val loseHomeGames: Int,
        val playedHomeGames: Int,
        val winHomeGames: Int)

data class UiStandingsAway(
        val teamID: Int?,
        val teamLogo: String?,
        val teamName: String?,
        val awayGoalDiff: Int,
        val awayPoints: Int,
        val drawAwayGames: Int,
        val goalsAwayGamesFor: Int,
        val goalsAwayGamesAgainst: Int,
        val loseAwayGames: Int,
        val playedAwayGames: Int,
        val winAwayGames: Int
)