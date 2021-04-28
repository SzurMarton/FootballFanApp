package com.footballfan.ui.football.stats

import com.footballfan.ui.football.stats.model.UiStatsData

sealed class StatsViewState

object Initial : StatsViewState()

object Loading : StatsViewState()

data class StatsReady(val stats: UiStatsData) : StatsViewState()

object Error : StatsViewState()