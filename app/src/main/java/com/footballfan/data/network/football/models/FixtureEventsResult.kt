package com.footballfan.data.network.football.models

data class FixtureEventsResult (val get: String?,val parameters: ParamsEvent, val errors: List<Error>?,
                           val results: Int?,val paging: Paging?,val response: List<Event>?)

data class ParamsEvent(val fixture:String?)

data class Event(val time: EventTime,val team:EventTeamInfo,val player:Player,val assist:Assist,val type: String?,
            val detail:String?,val comments: String?)

data class EventTime(val elapsed:Int?,val extra:Int?)

data class EventTeamInfo(val id: Int?,val name: String?,val logo: String?)

data class Player(val id:Int?,val name:String?)

data class Assist(val id:Int?,val name:String?)