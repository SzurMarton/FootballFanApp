package com.footballfan.ui.football.headtohead

import co.zsmb.rainbowcake.base.RainbowCakeViewModel
import javax.inject.Inject

class HeadToHeadViewModel @Inject constructor(
    private val headToHeadPresenter: HeadToHeadPresenter
) : RainbowCakeViewModel<HeadToHeadViewState>(Initial){

    fun loadHeadToHead(homeTeamID: String, awayTeamID: String) = execute {
        viewState = Loading
        val res = headToHeadPresenter.getHeadToHead(homeTeamID, awayTeamID)
        viewState = res?.let { HeadToHeadReady(it) } ?: Error
    }
}