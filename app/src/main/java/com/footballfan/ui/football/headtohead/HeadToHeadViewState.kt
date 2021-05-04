package com.footballfan.ui.football.headtohead

import com.footballfan.ui.football.headtohead.model.UiH2HFixture
import com.footballfan.ui.football.headtohead.model.UiHeadToHeadData

sealed class HeadToHeadViewState

object Initial : HeadToHeadViewState()

object Loading : HeadToHeadViewState()

data class HeadToHeadReady(val h2hFixtures: UiHeadToHeadData) : HeadToHeadViewState()

object Error : HeadToHeadViewState()