package com.footballfan.data.network.football

import com.footballfan.domain.models.football.*
import com.footballfan.networkutil.NetworkResponse
import com.footballfan.networkutil.executeNetworkCall

import javax.inject.Inject

class FootballDataSource @Inject constructor(private val footballApi: FootballApi){
    suspend fun getLeagues(season: Int) : NetworkResponse<DomainLeagueData> =
            executeNetworkCall{
                footballApi.getLeagues(season).let { it ->
                    DomainLeagueData(
                            leagues = it.response
                    )
                }
            }

    suspend fun getRounds(season: Int,leagueID: Int) : NetworkResponse<DomainRoundsData> =
            executeNetworkCall {
                footballApi.getRounds(season,leagueID).let {
                    DomainRoundsData(
                            rounds = it.response
                    )
                }
            }

    suspend fun getFixtures(season: Int,leagueID: Int) : NetworkResponse<DomainFixtureData> =
            executeNetworkCall {
                footballApi.getFixtures(season,leagueID).let {
                    DomainFixtureData(
                            fixtures = it.response
                    )
                }
            }

    suspend fun getEvents(fixtureID: String) : NetworkResponse<DomainEventsData> =
            executeNetworkCall {
                footballApi.getEvents(fixtureID).let {
                    DomainEventsData(
                            events = it.response
                    )
                }
            }

    suspend fun getStats(fixtureID: String) : NetworkResponse<DomainStatsData> =
            executeNetworkCall {
                footballApi.getStats(fixtureID).let {
                    DomainStatsData(
                            stats = it.response
                    )
                }
            }

    suspend fun getLineUps(fixtureID: String) : NetworkResponse<DomainLineUpsData> =
            executeNetworkCall {
                footballApi.getLineUps(fixtureID).let {
                    DomainLineUpsData(
                            lineups = it.response
                    )
                }
            }

    suspend fun getHeadtohead( teamIDs: String) : NetworkResponse<DomainH2HData> =
            executeNetworkCall {
                footballApi.getHeadtohead(teamIDs).let {
                    DomainH2HData(
                            h2h = it.response
                    )
                }
            }

}