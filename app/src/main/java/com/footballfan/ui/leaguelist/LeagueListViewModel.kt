package com.footballfan.ui.leaguelist

import co.zsmb.rainbowcake.base.RainbowCakeViewModel
import javax.inject.Inject

class LeagueListViewModel @Inject constructor(
    private val leagueListPresenter: LeagueListPresenter
) : RainbowCakeViewModel<LeagueListViewState>(Initial){
    fun load() = execute {
        viewState = Loading
        val leagueData = leagueListPresenter.getLeagues()
        viewState = if (leagueData != null){
            LeagueListReady(leagueData)
        }else{
            Error
        }
    }
}