package com.footballfan.ui.leaguelist

import co.zsmb.rainbowcake.withIOContext
import com.footballfan.domain.FootballInteractor
import com.footballfan.domain.models.DomainLeagueData
import com.footballfan.networkutil.SomeResult
import com.footballfan.ui.leaguelist.model.LeagueData
import com.footballfan.ui.leaguelist.model.LeagueUiData
import javax.inject.Inject

class LeagueListPresenter @Inject constructor(
    private val footballInteractor : FootballInteractor
){
    suspend fun getLeagues() : LeagueUiData? = withIOContext {
        when (val response = footballInteractor.getLeagues()){
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