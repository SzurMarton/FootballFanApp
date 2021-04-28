package com.footballfan.ui.football.lineups

import co.zsmb.rainbowcake.base.RainbowCakeViewModel
import javax.inject.Inject

class LineupViewModel @Inject constructor(
    private val lineupPresenter: LineupPresenter
) : RainbowCakeViewModel<LineupViewState>(Initial)
{
    fun loadLineup(fixtureID: String) = execute {
        viewState = Loading
        val lineups = lineupPresenter.getLineups(fixtureID)
        viewState = lineups?.let { LineupReady(it) } ?: Error
    }
}