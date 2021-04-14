package com.footballfan.ui.news.deatilnews

import co.zsmb.rainbowcake.base.RainbowCakeViewModel
import javax.inject.Inject

class DetailNewsViewModel @Inject constructor(private val detailnewspresenter : DetailNewsPresenter) : RainbowCakeViewModel<DetailNewsViewState>(Initial){

}