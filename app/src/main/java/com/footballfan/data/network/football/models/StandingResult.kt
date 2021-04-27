package com.footballfan.data.network.football.models

//TODO ?
data class StandingsResult(
        val errors: List<Any>,
        val `get`: String,
        val paging: PagingStandings,
        val parameters: ParametersStandings,
        val response: List<ResponseObjStandings>,
        val results: Int
)

data class PagingStandings(
        val current: Int,
        val total: Int
)

data class ParametersStandings(
        val league: String,
        val season: String
)

data class ResponseObjStandings(
        val league: LeagueInfoStandings
)

data class LeagueInfoStandings(
        val country: String,
        val flag: String,
        val id: Int,
        val logo: String,
        val name: String,
        val season: Int,
        val standings: List<List<Standing>>
)

data class Standing(
        val all: All,
        val away: Away,
        val description: String?,
        val form: String,
        val goalsDiff: Int,
        val group: String,
        val home: Home,
        val points: Int,
        val rank: Int,
        val status: String,
        val team: TeamInfoStandings,
        val update: String
)

data class All(
        val draw: Int,
        val goals: GoalsAll,
        val lose: Int,
        val played: Int,
        val win: Int
)

data class TeamInfoStandings(
        val id: Int?,
        val logo: String?,
        val name: String?
)

data class Away(
        val draw: Int,
        val goals: GoalsAway,
        val lose: Int,
        val played: Int,
        val win: Int
)

data class Home(
        val draw: Int,
        val goals: GoalsHome,
        val lose: Int,
        val played: Int,
        val win: Int
)

data class GoalsAll(
        val against: Int,
        val `for`: Int
)

data class GoalsAway(
        val against: Int,
        val `for`: Int
)

data class GoalsHome(
        val against: Int,
        val `for`: Int
)