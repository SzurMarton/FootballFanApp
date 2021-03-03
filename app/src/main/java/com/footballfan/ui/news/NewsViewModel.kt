package com.footballfan.ui.news

import co.zsmb.rainbowcake.base.RainbowCakeViewModel
import javax.inject.Inject

class NewsViewModel @Inject constructor(private val newsPresenter : NewsPresenter) : RainbowCakeViewModel<NewsViewState>(Loading){

}
