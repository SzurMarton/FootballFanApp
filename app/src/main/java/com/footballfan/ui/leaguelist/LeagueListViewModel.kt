package com.footballfan.ui.leaguelist

import android.util.Log
import co.zsmb.rainbowcake.base.OneShotEvent
import co.zsmb.rainbowcake.base.RainbowCakeViewModel
import com.footballfan.ui.leaguelist.model.LeagueData
import com.footballfan.ui.leaguelist.model.LeagueUiData
import javax.inject.Inject

class LeagueListViewModel @Inject constructor(
    private val leagueListPresenter: LeagueListPresenter
) : RainbowCakeViewModel<LeagueListViewState>(Initial){
    private var leagueList :LeagueUiData? = null

    class ListChangedEvent(val leagueData: LeagueUiData?) : OneShotEvent

    fun load() = execute {
        viewState = Loading
        //val leagueData = leagueListPresenter.getLeagues()
        leagueList = leagueListPresenter.getLeagues()
        viewState = leagueList?.let { LeagueListReady(it) } ?: Error
    }


    fun filterLeagueList(filter: String?){
        if (filter != null)
            leagueList?.leagues?.filter { it.name!!.contains(filter) }
        ListChangedEvent(leagueList)
    }
}