package com.footballfan.data.network.football.models

//Uses the Error and the Paging class from LeagueResult.kt
data class RoundResult(val get: String?,val parameters: ParametersRound,val errors: List<Error>?,
                  val results: Int?,val paging: Paging?,val response: List<String>?)

data class ParametersRound(val season: String?,val league:String?)