package com.footballfan.ui.football.fixturelist

import co.zsmb.rainbowcake.withIOContext
import com.footballfan.domain.FootballInteractor
import com.footballfan.domain.models.football.DomainFixtureData
import com.footballfan.domain.models.football.DomainRoundsData
import com.footballfan.networkutil.SomeResult
import com.footballfan.ui.football.fixturelist.model.FixtureListData
import com.footballfan.ui.football.fixturelist.model.FixtureListUiData
import com.footballfan.ui.football.fixturelist.model.RoundsData
import javax.inject.Inject

class FixtureListPresenter @Inject constructor(
        private val footballInteractor: FootballInteractor
){
    suspend fun getFixtures(season: Int,leagueID: Int) : FixtureListData? = withIOContext {
        when(val response = footballInteractor.getFixtures(season, leagueID)){
            is SomeResult -> response.result.toFixtureUiData()
            else -> null
        }
    }

    suspend fun getRounds(season: Int,leagueID: Int) : RoundsData? = withIOContext {
        when(val response = footballInteractor.getRounds(season, leagueID)){
            is SomeResult -> response.result.toRoundsData()
            else -> null
        }
    }

    private fun DomainFixtureData.toFixtureUiData() : FixtureListData{
        return FixtureListData(
                fixtures = fixtures?.map {
                    FixtureListUiData(
                            fixtureID = it.fixtureID ?: 0,
                            homeTeamName = it.homeTeamName ?: "",
                            homeTeamLogo = it.homeTeamLogo ?: "",
                            homeGoals = it.homeGoals.toString() ?: "-",
                            homeTeamWinner = it.homeTeamWinner ?: false,
                            awayTeamName = it.awayTeamName ?: "",
                            awayTeamLogo = it.awayTeamLogo ?: "",
                            awayGoals = it.awayGoals.toString() ?: "-",//TODO if null set to -
                            awayTeamWinner = it.awayTeamWinner ?: false,
                            leagueRound = it.leagueRound ?: "Null",
                            homeTeamID = it.homeTeamID ?: -1,
                            awayTeamID = it.awayTeamID ?: -1
                    )
                }
        )
    }

    private fun DomainRoundsData.toRoundsData() : RoundsData{
        return RoundsData(
                rounds = rounds
        )
    }
}