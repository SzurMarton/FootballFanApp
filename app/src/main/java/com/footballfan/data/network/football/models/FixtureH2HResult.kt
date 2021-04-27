package com.footballfan.data.network.football.models

data class FixtureH2HResult (val get: String?, val parameters: Paramash2h, val errors: List<Error>?,
                             val results: Int?, val paging: Paging?, val response: List<FixtureData>)

data class Paramash2h(val h2h: String?)