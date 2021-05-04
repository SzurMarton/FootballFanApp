package com.footballfan.ui.football.lineups

import co.zsmb.rainbowcake.withIOContext
import com.footballfan.domain.FootballInteractor
import com.footballfan.domain.models.football.DomainLineUpsData
import com.footballfan.networkutil.SomeResult
import com.footballfan.ui.football.lineups.model.UiLineupData
import com.footballfan.ui.football.lineups.model.UiPlayer
import javax.inject.Inject

class LineupPresenter @Inject constructor(
    private val footballInteractor: FootballInteractor
) {
    suspend fun getLineups(fixtureId: String): UiLineupData? = withIOContext {
        when (val response = footballInteractor.getLineUps(fixtureId)) {
            is SomeResult -> response.result.toUiLineupData()
            else -> null
        }
    }

    private fun DomainLineUpsData.toUiLineupData(): UiLineupData {
        return UiLineupData(
            homeCoachName = homeCoachName ?: "",
            awayCoachName = awayCoachName ?: "",
            homeFormation = homeFormation ?: "",
            awayFormation = awayFormation ?: "",
            homeStartXI = homeStartXI?.map {
                UiPlayer(
                    id = it.id ?: -1,
                    name = it.name ?: "",
                    pos = it.pos ?: "",
                    number = it.number ?: -1
                )
            } ?: emptyList(),
            homeSubstitutes = homeSubstitutes?.map {
                UiPlayer(
                    id = it.id ?: -1,
                    name = it.name ?: "",
                    pos = it.pos ?: "",
                    number = it.number ?: -1
                )
            } ?: emptyList(),
            awayStartXI = awayStartXI?.map {
                UiPlayer(
                    id = it.id ?: -1,
                    name = it.name ?: "",
                    pos = it.pos ?: "",
                    number = it.number ?: -1
                )
            } ?: emptyList(),
            awaySubstitutes = awaySubstitutes?.map {
                UiPlayer(
                    id = it.id ?: -1,
                    name = it.name ?: "",
                    pos = it.pos ?: "",
                    number = it.number ?: -1
                )
            } ?: emptyList()
        )
    }
}