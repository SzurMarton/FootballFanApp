package com.footballfan.data.network.football

import com.footballfan.domain.models.DomainLeagueData
import com.footballfan.domain.models.League
import com.footballfan.domain.models.LeagueData
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

}