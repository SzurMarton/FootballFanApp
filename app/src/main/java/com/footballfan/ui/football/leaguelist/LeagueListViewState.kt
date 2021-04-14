package com.footballfan.ui.football.leaguelist

import com.footballfan.ui.football.leaguelist.model.LeagueUiData

sealed class LeagueListViewState

object Initial : LeagueListViewState()

object Loading : LeagueListViewState()

data class LeagueListReady(val leagueData: LeagueUiData) : LeagueListViewState()

object Error : LeagueListViewState()