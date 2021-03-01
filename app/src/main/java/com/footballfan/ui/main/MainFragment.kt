package com.footballfan.ui.main

import co.zsmb.rainbowcake.base.RainbowCakeFragment
import co.zsmb.rainbowcake.dagger.getViewModelFromFactory
import com.footballfan.R
import com.footballfan.ui.main.ViewReady

class MainFragment : RainbowCakeFragment<MainViewState,MainViewModel>() {
    override fun provideViewModel(): MainViewModel = getViewModelFromFactory()
    override fun getViewResource(): Int = R.layout.activity_main

    override fun render(viewState: MainViewState) {
        when(viewState){
            ViewReady -> {}
        }
    }
}