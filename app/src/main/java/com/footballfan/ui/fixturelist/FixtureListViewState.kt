package com.footballfan.ui.fixturelist

import com.footballfan.ui.fixturelist.model.FixtureListData
import com.footballfan.ui.fixturelist.model.FixtureListUiData

sealed class FixtureListViewState

object Initial : FixtureListViewState()

object Loading : FixtureListViewState()

data class LeagueListReady(val fixtureListData: FixtureListData) : FixtureListViewState()

object Error : FixtureListViewState()