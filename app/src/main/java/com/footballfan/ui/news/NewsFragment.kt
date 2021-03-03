package com.footballfan.ui.news

import co.zsmb.rainbowcake.base.RainbowCakeFragment
import co.zsmb.rainbowcake.dagger.getViewModelFromFactory
import com.footballfan.R
import com.footballfan.ui.main.ViewReady

class NewsFragment : RainbowCakeFragment<NewsViewState,NewsViewModel>() {
    override fun provideViewModel(): NewsViewModel = getViewModelFromFactory()
    override fun getViewResource(): Int = R.layout.fragment_news

    override fun render(viewState: NewsViewState) {
        when(viewState){
            Loading -> {}
        }
    }

}