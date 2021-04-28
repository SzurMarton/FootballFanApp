package com.footballfan.ui.football.stats

import co.zsmb.rainbowcake.withIOContext
import com.footballfan.domain.FootballInteractor
import com.footballfan.domain.models.football.DomainStat
import com.footballfan.domain.models.football.DomainStatsData
import com.footballfan.networkutil.SomeResult
import com.footballfan.ui.football.leaguestandings.model.UiStandingsData
import com.footballfan.ui.football.stats.model.UiStat
import com.footballfan.ui.football.stats.model.UiStatObject
import com.footballfan.ui.football.stats.model.UiStatsData
import javax.inject.Inject

class StatsPresenter @Inject constructor(
    private val footballInteractor: FootballInteractor
) {
    suspend fun getStats(fixtureID: String) : UiStatsData? = withIOContext {
        when(val response = footballInteractor.getStats(fixtureID)){
            is SomeResult -> response.result.toUiStatsData()
            else -> null
        }
    }

    private fun DomainStatsData.toUiStatsData() : UiStatsData {
        return UiStatsData(
            homeTeamStats = stats?.first()?.let { it ->
                UiStat(
                    teamID = it.teamID ?: -1,
                    statistics = it.statistics?.map {
                        UiStatObject(
                            type = it.type ?: "",
                            value = it.value ?: ""
                        )
                    } ?: emptyList()
              )
            } ?: UiStat(-1, emptyList()),
            awayTeamStats = stats?.last()?.let { it ->
                UiStat(
                    teamID = it.teamID ?: -1,
                    statistics = it.statistics?.map {
                        UiStatObject(
                            type = it.type ?: "",
                            value = it.value ?: ""
                        )
                    } ?: emptyList()
                )
            } ?: UiStat(-1, emptyList())
        )
    }
}