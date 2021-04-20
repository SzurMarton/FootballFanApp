package com.footballfan.ui.football.fixturelist

import co.zsmb.rainbowcake.base.RainbowCakeViewModel
import com.footballfan.ui.football.fixturelist.model.FixtureListData
import com.footballfan.ui.football.fixturelist.model.RoundsData
import javax.inject.Inject

class FixtureListViewModel @Inject constructor(
        private val fixtureListPresenter: FixtureListPresenter
) : RainbowCakeViewModel<FixtureListViewState>(Initial){
    private var fixtureList: FixtureListData? = null
    private var rounds: RoundsData? = null

    fun loadFixturesData(leagueId:Int) = execute {
        viewState = Loading
        fixtureList = fixtureListPresenter.getFixtures(2020,leagueId) //TODO fix season
        rounds = fixtureListPresenter.getRounds(2020,leagueId)
        viewState = fixtureList?.let { rounds?.let { it1 -> DataReady(it, it1) } } ?: Error //TODO probably bad
    }
}