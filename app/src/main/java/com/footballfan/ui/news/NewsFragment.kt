package com.footballfan.ui.news

import android.os.Bundle
import android.view.View
import co.zsmb.rainbowcake.base.RainbowCakeFragment
import co.zsmb.rainbowcake.dagger.getViewModelFromFactory
import com.footballfan.R
import kotlinx.android.synthetic.main.fragment_news.*

class NewsFragment : RainbowCakeFragment<NewsViewState, NewsViewModel>(){
    override fun getViewResource() = R.layout.fragment_news
    override fun provideViewModel() = getViewModelFromFactory()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onStart() {
        super.onStart()
        viewModel.load()
    }

    override fun render(viewState: NewsViewState) {
        when(viewState){
            is Loading -> textnews.text = "Loading"
            is NewsListReady -> textnews.text = viewState.newsData.articles?.size.toString()
            is Error -> textnews.text = "Error"
        }
    }

}