package com.footballfan.ui.football.leaguestandings

import co.zsmb.rainbowcake.base.RainbowCakeViewModel
import javax.inject.Inject

class StandingsViewModel @Inject constructor(
        private val standingsPresenter: StandingsPresenter
) : RainbowCakeViewModel<StandingsViewState>(Initial){
    //TODO store the 3 list
    fun loadStandings(season: Int,leagueID: Int) = execute {
        viewState = Loading
        var res = standingsPresenter.getStandings(season, leagueID)
        viewState = res?.let { StandingsListReady(it) } ?: Error
    }
}