package com.footballfan.ui.football.fixturelist

import com.footballfan.ui.football.fixturelist.model.FixtureListData

sealed class FixtureListViewState

object Initial : FixtureListViewState()

object Loading : FixtureListViewState()

data class FixtureListReady(val fixtureListData: FixtureListData) : FixtureListViewState()

object Error : FixtureListViewState()