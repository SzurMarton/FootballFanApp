package com.footballfan.ui.news

import android.util.Log
import co.zsmb.rainbowcake.base.RainbowCakeViewModel
import java.io.IOException
import javax.inject.Inject

class NewsViewModel @Inject constructor(private val newsPresenter : NewsPresenter) : RainbowCakeViewModel<NewsViewState>(Loading){
    init {
        execute { loadNews() }
    }

    private suspend fun loadNews() {
        viewState = Loading
       viewState = try {
            val items = newsPresenter.getNewsItems()
           Log.d("asd",items.toString())
                NewsListReady(items)
        }catch (e : IOException){
            NetworkError
        }
    }
}
