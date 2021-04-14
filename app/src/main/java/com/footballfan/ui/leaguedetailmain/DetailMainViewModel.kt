package com.footballfan.ui.leaguedetailmain

import co.zsmb.rainbowcake.base.RainbowCakeViewModel
import javax.inject.Inject

class DetailMainViewModel @Inject constructor(
        private val detailMainPresenter: DetailMainPresenter
) : RainbowCakeViewModel<DetailMainViewState>(Initial){
    var leagueID :Int? = null
}