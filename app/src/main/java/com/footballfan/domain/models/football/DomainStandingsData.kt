package com.footballfan.domain.models.football

import com.footballfan.data.network.football.models.GoalsAll
//TODO change List to List<List> because leagues like ucl
data class DomainStandingsData(
        val leagueID: Int,
        val leagueLogo: String,
        val leagueName: String,
        val season: Int,
        val standings: List<DomainStandings>
)

data class DomainStandings(
        val teamID: Int?,
        val teamLogo: String?,
        val teamName: String?,
        val goalsDiff: Int,
        val points: Int,
        val drawAllGames: Int,
        val goalsAllGamesFor: Int,
        val goalsAllGamesAgainst: Int,
        val loseAllGames: Int,
        val playedAllGames: Int,
        val winAllGames: Int,
        val drawAwayGames: Int,
        val goalsAwayGamesFor: Int,
        val goalsAwayGamesAgainst: Int,
        val loseAwayGames: Int,
        val playedAwayGames: Int,
        val winAwayGames: Int,
        val drawHomeGames: Int,
        val goalsHomeGamesFor: Int,
        val goalsHomeGamesAgainst: Int,
        val loseHomeGames: Int,
        val playedHomeGames: Int,
        val winHomeGames: Int
)