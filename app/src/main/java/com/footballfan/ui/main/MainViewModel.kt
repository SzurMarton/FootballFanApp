package com.footballfan.ui.main

import co.zsmb.rainbowcake.base.RainbowCakeViewModel
import javax.inject.Inject


class MainViewModel  @Inject constructor(private val mainPresenter: MainPresenter) : RainbowCakeViewModel<MainViewState>(ViewReady) {
}