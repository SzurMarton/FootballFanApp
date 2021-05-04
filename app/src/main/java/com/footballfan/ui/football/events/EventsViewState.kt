package com.footballfan.ui.football.events

import com.footballfan.ui.football.events.model.UiEventsData
import com.footballfan.ui.football.lineups.LineupViewState
import com.footballfan.ui.football.lineups.model.UiLineupData

sealed class EventsViewState

object Initial : EventsViewState()

object Loading : EventsViewState()

data class EventsReady(val events : UiEventsData) : EventsViewState()

object Error : EventsViewState()