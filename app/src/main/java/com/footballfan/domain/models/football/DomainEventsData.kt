package com.footballfan.domain.models.football

import com.footballfan.data.network.football.models.Event

data class DomainEventsData(val events: List<DomainEvent>?)

data class DomainEvent(
        val time:Int?,
        val teamID:Int?,
        val teamName:String?,
        val logo: String?,
        val eventPlayerID: Int?,
        val eventPlayerName: String?,
        val eventAssistID: Int?,
        val eventAssistName: String?,
        val type: String?,
        val detail:String?
)