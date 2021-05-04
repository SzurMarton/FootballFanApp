package com.footballfan.ui.football.events.model

data class UiEventsData(val events: List<UiEvent>)

data class UiEvent(
    val time:Int,
    val teamID:Int,
    val teamName:String,
    //val logo: String,
    val eventPlayerID: Int,
    val eventPlayerName: String,
    val eventAssistID: Int,
    val eventAssistName: String,
    val type: String,
    val detail:String
)