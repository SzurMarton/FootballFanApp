package com.footballfan.domain

import com.footballfan.data.network.football.FootballDataSource
import com.footballfan.domain.models.football.*
import com.footballfan.networkutil.DataTransferResponse
import com.footballfan.networkutil.DataTransferSuccess
import com.footballfan.networkutil.NetworkResult
import com.footballfan.networkutil.NetworkUnavailableNotCached
import javax.inject.Inject

class FootballInteractor @Inject constructor(
    private val footballDataSource: FootballDataSource
){
    suspend fun getLeagues(season: Int) : DataTransferResponse<DomainLeagueData> {
        return when(val response = footballDataSource.getLeagues(season)){
            is NetworkResult -> {
                DataTransferSuccess(response.result)
            }
            else -> {
                NetworkUnavailableNotCached
            }
        }
    }

    suspend fun getRounds(season: Int,leagueID:Int) : DataTransferResponse<DomainRoundsData> {
        return when(val response = footballDataSource.getRounds(season,leagueID)){
            is NetworkResult -> {
                DataTransferSuccess(response.result)
            }
            else -> {
                NetworkUnavailableNotCached
            }
        }
    }

    suspend fun getFixtures(season: Int,leagueID: Int) : DataTransferResponse<DomainFixtureData> {
        return when(val response = footballDataSource.getFixtures(season,leagueID)){
            is NetworkResult -> {
                DataTransferSuccess(response.result)
            }
            else -> {
                NetworkUnavailableNotCached
            }
        }
    }

    suspend fun getEvents(fixtureID: String) : DataTransferResponse<DomainEventsData> {
        return when(val response = footballDataSource.getEvents(fixtureID)){
            is NetworkResult -> {
                DataTransferSuccess(response.result)
            }
            else -> {
                NetworkUnavailableNotCached
            }
        }
    }

    suspend fun getStats(fixtureID: String) : DataTransferResponse<DomainStatsData> {
        return when(val response = footballDataSource.getStats(fixtureID)){
            is NetworkResult -> {
                DataTransferSuccess(response.result)
            }
            else -> {
                NetworkUnavailableNotCached
            }
        }
    }

    suspend fun getLineUps(fixtureID: String) : DataTransferResponse<DomainLineUpsData> {
        return when(val response = footballDataSource.getLineUps(fixtureID)){
            is NetworkResult -> {
                DataTransferSuccess(response.result)
            }
            else -> {
                NetworkUnavailableNotCached
            }
        }
    }

    suspend fun getHeadtohead(teamIDs: String) : DataTransferResponse<DomainH2HData> {
        return when(val response = footballDataSource.getHeadtohead(teamIDs)){
            is NetworkResult -> {
                DataTransferSuccess(response.result)
            }
            else -> {
                NetworkUnavailableNotCached
            }
        }
    }
}