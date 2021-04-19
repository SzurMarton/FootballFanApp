package com.footballfan.ui.football.leaguestandings

import co.zsmb.rainbowcake.withIOContext
import com.footballfan.domain.FootballInteractor
import com.footballfan.domain.models.football.DomainStandingsData
import com.footballfan.networkutil.SomeResult
import com.footballfan.ui.football.leaguestandings.model.UiStandingsAll
import com.footballfan.ui.football.leaguestandings.model.UiStandingsAway
import com.footballfan.ui.football.leaguestandings.model.UiStandingsData
import com.footballfan.ui.football.leaguestandings.model.UiStandingsHome
import javax.inject.Inject

class StandingsPresenter @Inject constructor(
        private val footballInteractor: FootballInteractor
){
    suspend fun getStandings(season: Int,leagueID: Int) : UiStandingsData? = withIOContext {
        when(val response = footballInteractor.getStandings(season, leagueID)){
            is SomeResult -> response.result.toUiStandingsData()
            else -> null
        }
    }

    private fun DomainStandingsData.toUiStandingsData() : UiStandingsData{
        //TODO handle nulls
        return UiStandingsData(
                leagueID = leagueID ?: 0,
                leagueLogo = leagueLogo ?: "",
                leagueName = leagueName ?: "",
                season = season ?: 0,
                standingsAll = standings.map {
                    UiStandingsAll(
                            teamID = it.teamID,
                            teamName = it.teamName,
                            teamLogo = it.teamLogo,
                            playedAllGames = it.playedAllGames,
                            drawAllGames = it.drawAllGames,
                            winAllGames = it.winAllGames,
                            loseAllGames = it.loseAllGames,
                            goalsAllGamesAgainst = it.goalsAllGamesAgainst,
                            goalsAllGamesFor = it.goalsAllGamesFor,
                            points = it.points,
                            goalDiff = it.goalsDiff
                    )
                },
                standingsAway = standings.map {
                    UiStandingsAway(
                            teamID = it.teamID,
                            teamName = it.teamName,
                            teamLogo = it.teamLogo,
                            awayGoalDiff = it.goalsAwayGamesFor - it.goalsAwayGamesAgainst,
                            awayPoints = it.winAwayGames * 3 + it.drawAwayGames,
                            playedAwayGames = it.playedAwayGames,
                            drawAwayGames = it.drawAwayGames,
                            winAwayGames = it.winAwayGames,
                            loseAwayGames = it.loseAwayGames,
                            goalsAwayGamesAgainst = it.goalsAwayGamesAgainst,
                            goalsAwayGamesFor = it.goalsAwayGamesFor
                    )
                },
                standingsHome = standings.map {
                    UiStandingsHome(
                            teamID = it.teamID,
                            teamName = it.teamName,
                            teamLogo = it.teamLogo,
                            homeGoalDiff = it.goalsHomeGamesFor - it.goalsHomeGamesAgainst,
                            homePoints = it.winHomeGames * 3 + it.drawHomeGames,
                            playedHomeGames = it.playedHomeGames,
                            drawHomeGames = it.drawHomeGames,
                            winHomeGames = it.winHomeGames,
                            loseHomeGames = it.loseHomeGames,
                            goalsHomeGamesAgainst = it.goalsHomeGamesAgainst,
                            goalsHomeGamesFor = it.goalsHomeGamesFor
                    )
                }
        )
    }
}