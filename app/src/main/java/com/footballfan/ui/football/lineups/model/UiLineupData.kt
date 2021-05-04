package com.footballfan.ui.football.lineups.model

import com.footballfan.data.network.football.models.PlayerLineUp

data class UiLineupData(
    val homeCoachName: String,
    val homeFormation: String,
    val awayCoachName: String,
    val awayFormation: String,
    val homeStartXI: List<UiPlayer>, // we can use the PlayerLine no need to transform because we need all data in PlayerLineup
    val awayStartXI: List<UiPlayer>,
    val homeSubstitutes: List<UiPlayer>,
    val awaySubstitutes: List<UiPlayer>
)

data class UiPlayer(val id: Int,val name: String,val number:Int,val pos:String)
