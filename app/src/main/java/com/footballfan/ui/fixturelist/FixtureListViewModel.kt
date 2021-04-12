package com.footballfan.ui.fixturelist

import co.zsmb.rainbowcake.base.RainbowCakeViewModel
import com.footballfan.ui.fixturelist.model.FixtureListData
import javax.inject.Inject

class FixtureListViewModel @Inject constructor(
        private val fixtureListPresenter: FixtureListPresenter
) : RainbowCakeViewModel<FixtureListViewState>(Initial){
    private var fixtureList: FixtureListData? = null

    fun loadFixtures() = execute {
        viewState = Loading
        //Todo get league id from main fragment
    }
}