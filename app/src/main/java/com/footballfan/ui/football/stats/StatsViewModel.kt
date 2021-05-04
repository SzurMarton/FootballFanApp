package com.footballfan.ui.football.stats

import co.zsmb.rainbowcake.base.RainbowCakeViewModel
import javax.inject.Inject

class StatsViewModel @Inject constructor(
    private val statsPresenter: StatsPresenter
) : RainbowCakeViewModel<StatsViewState>(Initial){

    fun loadStats(fixtureID : String) = execute {
        viewState = Loading
        val res = statsPresenter.getStats(fixtureID)
        viewState = res?.let { StatsReady(it) } ?: Error
    }
}