package com.footballfan.data.network.football.models

data class FixtureLineUpsResult(
        val errors: List<Any>?,
        val `get`: String?,
        val paging: PagingLineUp?,
        val parameters: ParametersLineUp?,
        val response: List<Response>?,
        val results: Int?
)

data class ParametersLineUp(
        val fixture: String?
)

data class PagingLineUp(
        val current: Int?,
        val total: Int?
)

data class TeamLineup(
        val id: Int?,
        val logo: String?,
        val name: String?
)

data class PlayerLineUp(
        val id: Int?,
        val name: String?,
        val number: Int?,
        val pos: String?
)

data class Substitute(
        val player: PlayerLineUp?
)

data class StartXI(
        val player: PlayerLineUp?
)

data class Coach(
        val id: Int?,
        val name: String?,
        val photo: String?
)

data class Response(
        val coach: Coach?,
        val formation: String?,
        val startXI: List<StartXI>?,
        val substitutes: List<Substitute>?,
        val team: TeamLineup?
)

