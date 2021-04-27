package com.footballfan.ui.news.newslist

import co.zsmb.rainbowcake.base.RainbowCakeViewModel
import javax.inject.Inject

class NewsViewModel @Inject constructor(
    private val newsPresenter: NewsPresenter
) : RainbowCakeViewModel<NewsViewState>(Initial){
    fun load() = execute {
        viewState = Loading
        val newsData = newsPresenter.getNewsData()
        viewState = if (newsData != null) {
            NewsListReady(newsData)
        } else {
            Error
        }
    }
}