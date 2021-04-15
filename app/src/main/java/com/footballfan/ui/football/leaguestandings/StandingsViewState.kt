package com.footballfan.ui.football.leaguestandings

import com.footballfan.ui.football.leaguestandings.model.UiStandingsData

sealed class StandingsViewState

object Initial : StandingsViewState()

object Loading : StandingsViewState()

data class StandingsListReady(val standingsData: UiStandingsData) : StandingsViewState()

object Error : StandingsViewState()