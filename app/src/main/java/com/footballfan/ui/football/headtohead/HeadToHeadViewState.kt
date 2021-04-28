package com.footballfan.ui.football.headtohead

sealed class HeadToHeadViewState

object Initial : HeadToHeadViewState()

object Loading : HeadToHeadViewState()

data class HeadToHeadReady(val asd: String) : HeadToHeadViewState()

object Error : HeadToHeadViewState()