package com.footballfan.ui.fixturelist

import co.zsmb.rainbowcake.base.RainbowCakeFragment
import co.zsmb.rainbowcake.dagger.getViewModelFromFactory
import com.footballfan.R

class FixtureListFragment : RainbowCakeFragment<FixtureListViewState,FixtureListViewModel>(){
    override fun provideViewModel() = getViewModelFromFactory()
    override fun getViewResource() = R.layout.fragment_fixturelist

    override fun render(viewState: FixtureListViewState) {
        TODO("Not yet implemented")
    }

}