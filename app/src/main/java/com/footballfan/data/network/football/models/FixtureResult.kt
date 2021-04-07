package com.footballfan.data.network.football.models

//Uses the Error and the Paging class from LeagueResult.kt
data class FixtureResult(val get: String?,val parameters: ParametersFixture, val errors: List<Error>?,
                    val results: Int?,val paging: Paging?,val response: List<FixtureData>?)

data class ParametersFixture(val season: String?,val league:String?)

data class FixtureData (val fixture: Fixture?,val league: LeagueFixture?,val teams: Teams?,val goals: Goals?,
                   val score: Score?)

data class Fixture(val id:Int?,val referee:String?,val timezone:String?,
              val date:String?,val timestamp:Int?,val periods:Periods?,
              val venue: Venue?, val status:Status?)

data class Periods(val first:Int?,val second:Int?)

data class Venue(val id:Int?,val name:String?,val city:String?)

data class Status(val long:String?,val short:String?,val elapsed:String?)

data class LeagueFixture(val id: Int?, val name:String?,val country: String?,val logo:String?,
                    val flag:String?,val season: String?,val round: String?)

data class Teams(val home: Team?,val away: Team?)

data class Team(val id: Int?,val name: String?,val logo: String?,val winner:Boolean?)

data class Goals(val home:Int?,val away: Int?)

data class Score(val halftime: Goals?,val fulltime:Goals?,val extratime:Goals?,val penalty: Penalty?)

data class Penalty(val home:Int?,val away: Int?)
