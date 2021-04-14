package com.footballfan.ui.football.leaguelist

import co.zsmb.rainbowcake.withIOContext
import com.footballfan.domain.FootballInteractor
import com.footballfan.domain.models.football.DomainLeagueData
import com.footballfan.networkutil.SomeResult
import com.footballfan.ui.football.leaguelist.model.LeagueData
import com.footballfan.ui.football.leaguelist.model.LeagueUiData
import javax.inject.Inject

class LeagueListPresenter @Inject constructor(
    private val footballInteractor : FootballInteractor
){
    suspend fun getLeagues(season: Int) : LeagueUiData? = withIOContext {
        when (val response = footballInteractor.getLeagues(season)){
            is SomeResult -> response.result.toLeagueUiData()
            else -> null
    }
    }

    private fun DomainLeagueData.toLeagueUiData() : LeagueUiData{
        return LeagueUiData(
            leagues = leagues?.map {
                LeagueData(
                    id = it.league?.id,
                    name = it.league?.name ?: "",
                    logo = it.league?.logo ?: "",
                    country = it.country?.name ?: "",
                    flag = it.country?.flag ?: ""
                )
            }
        )
    }
}