package com.footballfan.ui.football.leaguestandings

import co.zsmb.rainbowcake.base.RainbowCakeViewModel
import com.footballfan.ui.football.leaguestandings.model.UiStandingsAll
import com.footballfan.ui.football.leaguestandings.model.UiStandingsAway
import com.footballfan.ui.football.leaguestandings.model.UiStandingsHome
import javax.inject.Inject

class StandingsViewModel @Inject constructor(
        private val standingsPresenter: StandingsPresenter
) : RainbowCakeViewModel<StandingsViewState>(Initial){
    private lateinit var standingsAll: List<UiStandingsAll>
    private lateinit var standingsHome: List<UiStandingsHome>
    private lateinit var standingsAway: List<UiStandingsAway>

    fun loadStandings(season: Int,leagueID: Int) = execute {
        viewState = Loading
        var res = standingsPresenter.getStandings(season, leagueID)
        if (res != null) {
            standingsAll = res.standingsAll
            standingsHome = res.standingsHome
            standingsAway = res.standingsAway
        }
        viewState = res?.let { StandingsListReady(it) } ?: Error
    }

}