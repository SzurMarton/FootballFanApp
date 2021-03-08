package com.footballfan.ui.news

import android.util.Log
import co.zsmb.rainbowcake.base.RainbowCakeFragment
import co.zsmb.rainbowcake.dagger.getViewModelFromFactory
import co.zsmb.rainbowcake.extensions.exhaustive
import com.footballfan.R
import com.footballfan.ui.main.ViewReady
import kotlinx.android.synthetic.main.fragment_news.*

class NewsFragment : RainbowCakeFragment<NewsViewState,NewsViewModel>() {
    override fun provideViewModel(): NewsViewModel = getViewModelFromFactory()
    override fun getViewResource(): Int = R.layout.fragment_news

    override fun render(viewState: NewsViewState) {
        when(viewState){
            Loading -> {
                //viewFlipperMain.displayedChild = 0
            }
            is NewsListReady -> {
                texttest.text =  viewState.news?.size.toString()
                viewFlipperMain.displayedChild = 0
            }
            NetworkError -> {
                Log.d("asd","Network errror")
            }
        }.exhaustive
    }

}