package com.footballfan.data.network.football.models

data class FixtureLineUpsResult(val get: String?,val parameters: ParamsLineUp, val errors: List<Error>?,
                           val results: Int?,val paging: Paging?,val response: List<LineUpData>?)

data class ParamsLineUp(val fixture:String?)

data class LineUpData(val team:TeamLineupInfo?,val coach: Coach?,val formation:String?,
                 val startXI: List<PlayerLineUp>?,val substitutes:List<PlayerLineUp>?)

data class TeamLineupInfo(val id: Int?,val name: String?,val logo: String?)

data class Coach(val id: Int?,val name: String?)


data class PlayerLineUp(val id: Int?,val name: String?,val number:Int?,val pos:String?)