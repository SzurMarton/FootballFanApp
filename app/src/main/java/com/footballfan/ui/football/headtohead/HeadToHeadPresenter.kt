package com.footballfan.ui.football.headtohead

import co.zsmb.rainbowcake.withIOContext
import com.footballfan.domain.FootballInteractor
import com.footballfan.domain.models.football.DomainH2HData
import com.footballfan.domain.models.football.DomainH2HFixture
import com.footballfan.networkutil.SomeResult
import com.footballfan.ui.football.headtohead.model.UiH2HFixture
import com.footballfan.ui.football.headtohead.model.UiHeadToHeadData
import javax.inject.Inject

class HeadToHeadPresenter @Inject constructor(
    private val footballInteractor: FootballInteractor
) {
    suspend fun getHeadToHead(homeTeamID: String, awayTeamID: String) : UiHeadToHeadData?  = withIOContext {
        val teamids = "$homeTeamID-$awayTeamID"
        when(val response = footballInteractor.getHeadToHead(teamids)){
            is SomeResult -> response.result.toUiHeadToHeadData()
            else -> null
        }
    }
    
    private fun DomainH2HData.toUiHeadToHeadData() : UiHeadToHeadData {
        return UiHeadToHeadData(
                h2hfixtures = h2hfixtures?.map { 
                    UiH2HFixture(
                            fixtureID = it.fixtureID ?: -1,
                            date = it.date ?: "",
                            homeTeamID = it.homeTeamID ?: -1,
                            awayTeamId = it.awayTeamId ?: -1,
                            homeTeamLogo = it.homeTeamLogo ?: "",
                            awayTeamLogo = it.awayTeamLogo ?: "",
                            homeTeamName = it.homeTeamName ?: "",
                            awayTeamName = it.awayTeamName ?: "",
                            homeGoals = it.homeGoals.toString(),
                            awayGoals = it.awayGoals.toString(),
                            homeWinner = it.homeWinner ?: false,
                            awayWinner = it.awayWinner ?: false
                    )
                } ?: emptyList()
        )
    }
}