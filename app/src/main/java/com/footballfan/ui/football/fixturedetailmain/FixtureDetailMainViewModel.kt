package com.footballfan.ui.football.fixturedetailmain

import co.zsmb.rainbowcake.base.RainbowCakeViewModel
import com.footballfan.ui.news.deatilnews.DetailNewsPresenter
import javax.inject.Inject

class FixtureDetailMainViewModel @Inject constructor(private val fixtureDetailMainPresenter: FixtureDetailMainPresenter): RainbowCakeViewModel<FixtureDetailMainViewState>(Initial)
{

}