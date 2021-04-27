package com.footballfan.ui.football.leaguelist

import co.zsmb.rainbowcake.base.RainbowCakeViewModel
import com.footballfan.ui.football.leaguelist.model.LeagueUiData
import javax.inject.Inject

class LeagueListViewModel @Inject constructor(
    private val leagueListPresenter: LeagueListPresenter
) : RainbowCakeViewModel<LeagueListViewState>(Initial){
    private var leagueList :LeagueUiData? = null


    fun load() = execute {
        viewState = Loading
        //val leagueData = leagueListPresenter.getLeagues()
        //TODO get season from the user with choose season functionality
        leagueList = leagueListPresenter.getLeagues(2020)
        viewState = leagueList?.let { LeagueListReady(it) } ?: Error
    }


}