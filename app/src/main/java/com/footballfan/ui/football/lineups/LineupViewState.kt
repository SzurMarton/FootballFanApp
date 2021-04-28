package com.footballfan.ui.football.lineups

import com.footballfan.ui.football.lineups.model.UiLineupData

sealed class LineupViewState

object Initial : LineupViewState()

object Loading : LineupViewState()

data class LineupReady(val lineups : UiLineupData) : LineupViewState()

object Error : LineupViewState()