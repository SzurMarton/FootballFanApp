package com.footballfan.data.network.football

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface FootballApi {
    @Headers("x-rapidapi-host: v3.football.api-sports.io",
            "x-rapidapi-key: b55807bf0eeb17ba74645dce4c2a4a43")
    @GET("/leagues")
    suspend fun getLeagues(@Query("season") season: Int?) : LeagueResult
}