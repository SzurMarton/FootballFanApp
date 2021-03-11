package com.footballfan.ui.deatilnews

import co.zsmb.rainbowcake.base.RainbowCakeViewModel
import javax.inject.Inject

class DetailNewsViewModel @Inject constructor(private val detailnewspresenter : DetailNewsPresenter) : RainbowCakeViewModel<DetailNewsViewState>(Initial){

}