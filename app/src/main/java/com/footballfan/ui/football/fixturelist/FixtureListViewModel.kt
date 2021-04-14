package com.footballfan.ui.football.fixturelist

import co.zsmb.rainbowcake.base.RainbowCakeViewModel
import com.footballfan.ui.football.fixturelist.model.FixtureListData
import javax.inject.Inject

class FixtureListViewModel @Inject constructor(
        private val fixtureListPresenter: FixtureListPresenter
) : RainbowCakeViewModel<FixtureListViewState>(Initial){
    private var fixtureList: FixtureListData? = null

    fun loadFixtures(leagueId:Int) = execute {
        viewState = Loading
        fixtureList = fixtureListPresenter.getFixtures(2020,leagueId) //TODO fix season
        viewState = fixtureList?.let { FixtureListReady(it) } ?: Error
    }
}