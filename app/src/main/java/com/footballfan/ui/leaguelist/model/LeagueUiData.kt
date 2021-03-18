package com.footballfan.ui.leaguelist.model

data class LeagueUiData(val leagues: List<LeagueData>?)

data class LeagueData(
    val id :Int?,
    val name: String?,
    val logo: String?,
    val country: String?,
    val flag:String
)