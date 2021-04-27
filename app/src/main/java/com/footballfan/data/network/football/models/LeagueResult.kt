package com.footballfan.data.network.football.models


data class LeagueResult(val get: String?,
                        val parameters: Parameters,
                        val errors: List<Error>?,
                        val results: Int?,
                        val paging: Paging?,
                        val response: List<ResponseObject>)

data class Parameters(val season: String?)

class Error()

data class Paging(val current:Int?,
                  val total:Int?)

data class ResponseObject(val league: League?,
                          val country: Country?,
                          val seasons: List<Season>?)

data class League(val id: Int?,
                  val name:String?,
                  val type: String?,
                  val logo:String?)

data class Country(val name:String?,
                   val code:String?,
                   val flag:String?)

data class Season(val year: Int?,
                  val start:String?,
                  val end:String?,
                  val current: Boolean?,
                  val coverage: Coverage?,
                  val standings:Boolean?,
                  val players:Boolean?,
                  val top_scorers:Boolean?,
                  val predictions:Boolean?,
                  val odds:Boolean?)

data class Coverage(val fixtures: Fixtures?)

data class Fixtures(val events:Boolean?,
                    val lineups:Boolean?,
                    val statistics_fixtures:Boolean?,
                    val statistics_players: Boolean?)
