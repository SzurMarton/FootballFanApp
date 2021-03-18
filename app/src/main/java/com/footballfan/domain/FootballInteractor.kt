package com.footballfan.domain

import com.footballfan.data.network.football.FootballDataSource
import com.footballfan.domain.models.DomainLeagueData
import com.footballfan.networkutil.DataTransferResponse
import com.footballfan.networkutil.DataTransferSuccess
import com.footballfan.networkutil.NetworkResult
import com.footballfan.networkutil.NetworkUnavailableNotCached
import javax.inject.Inject

class FootballInteractor @Inject constructor(
    private val footballDataSource: FootballDataSource
){
    suspend fun getLeagues() : DataTransferResponse<DomainLeagueData> {
        return when(val response = footballDataSource.getLeagues()){
            is NetworkResult -> {
                DataTransferSuccess(response.result)
            }
            else -> {
                NetworkUnavailableNotCached
            }
        }
    }
}