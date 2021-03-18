package com.footballfan.data.network.football

import com.footballfan.domain.models.DomainLeagueData
import com.footballfan.domain.models.League
import com.footballfan.domain.models.LeagueData
import com.footballfan.networkutil.NetworkResponse
import com.footballfan.networkutil.executeNetworkCall

import javax.inject.Inject

class FootballDataSource @Inject constructor(private val footballApi: FootballApi){
    suspend fun getLeagues() : NetworkResponse<DomainLeagueData> =
            executeNetworkCall{
                footballApi.getLeagues(2020).let { it ->
                    DomainLeagueData(
                        leagues = it.response
                    )
                }
            }

}