package com.footballfan.ui.leaguelist

import com.footballfan.ui.leaguelist.model.LeagueUiData
import com.footballfan.ui.news.model.UiNewsData

sealed class LeagueListViewState

object Initial : LeagueListViewState()

object Loading : LeagueListViewState()

data class LeagueListReady(val leagueData: LeagueUiData) : LeagueListViewState()

object Error : LeagueListViewState()