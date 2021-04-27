package com.footballfan.ui.football.fixturelist

import com.footballfan.ui.football.fixturelist.model.FixtureListData
import com.footballfan.ui.football.fixturelist.model.RoundsData

sealed class FixtureListViewState

object Initial : FixtureListViewState()

object Loading : FixtureListViewState()

data class DataReady(val fixtureListData: FixtureListData,val rounds: RoundsData) : FixtureListViewState()

object Error : FixtureListViewState()