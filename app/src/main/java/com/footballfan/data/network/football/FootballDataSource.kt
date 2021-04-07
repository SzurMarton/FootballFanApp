package com.footballfan.data.network.football

import com.footballfan.domain.models.football.DomainFixtureData
import com.footballfan.domain.models.football.DomainLeagueData
import com.footballfan.domain.models.football.DomainRoundsData
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

}