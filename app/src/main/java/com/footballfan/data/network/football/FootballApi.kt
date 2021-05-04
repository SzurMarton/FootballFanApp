package com.footballfan.data.network.football

import com.footballfan.data.network.football.models.*
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface FootballApi {
    @Headers("x-rapidapi-host: v3.football.api-sports.io",
            "x-rapidapi-key: b55807bf0eeb17ba74645dce4c2a4a43")
    @GET("/leagues")
    suspend fun getLeagues(@Query("season") season: Int?) : LeagueResult

    @Headers("x-rapidapi-host: v3.football.api-sports.io",
                     "x-rapidapi-key: b55807bf0eeb17ba74645dce4c2a4a43")
    @GET("/fixtures/rounds")
    suspend fun getRounds(@Query("season") season: Int?,@Query("league") league: Int?) : RoundResult

    @Headers("x-rapidapi-host: v3.football.api-sports.io",
            "x-rapidapi-key: b55807bf0eeb17ba74645dce4c2a4a43")
    @GET("/fixtures")
    suspend fun getFixtures(@Query("season") season: Int?, @Query("league") league: Int?) : FixtureResult

    @Headers("x-rapidapi-host: v3.football.api-sports.io",
            "x-rapidapi-key: b55807bf0eeb17ba74645dce4c2a4a43")
    @GET("/fixtures")
    suspend fun getFixture(@Query("id") fixtureID: Int) : FixtureResult

    @Headers("x-rapidapi-host: v3.football.api-sports.io",
            "x-rapidapi-key: b55807bf0eeb17ba74645dce4c2a4a43")
    @GET("/fixtures/events")
    suspend fun getEvents(@Query("fixture") fixtureid: String?) : FixtureEventsResult

    @Headers("x-rapidapi-host: v3.football.api-sports.io",
            "x-rapidapi-key: b55807bf0eeb17ba74645dce4c2a4a43")
    @GET("/fixtures/statistics")
    suspend fun getStats(@Query("fixture") fixtureid: String) : FixtureStatsResult

    @Headers("x-rapidapi-host: v3.football.api-sports.io",
            "x-rapidapi-key: b55807bf0eeb17ba74645dce4c2a4a43")
    @GET("/fixtures/lineups")
    suspend fun getLineUps(@Query("fixture") fixtureid: String) : FixtureLineUpsResult

    @Headers("x-rapidapi-host: v3.football.api-sports.io",
            "x-rapidapi-key: b55807bf0eeb17ba74645dce4c2a4a43")
    @GET("/fixtures/headtohead")
    suspend fun getHeadtohead(@Query("h2h") teamids: String) : FixtureH2HResult

    @Headers("x-rapidapi-host: v3.football.api-sports.io",
            "x-rapidapi-key: b55807bf0eeb17ba74645dce4c2a4a43")
    @GET("/standings")
    suspend fun getStandings(@Query("season") season: Int,@Query("league") leagueid: Int) : StandingsResult
}