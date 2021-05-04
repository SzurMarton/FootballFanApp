package com.footballfan.ui.football.events

import co.zsmb.rainbowcake.withIOContext
import com.footballfan.domain.FootballInteractor
import com.footballfan.domain.models.football.DomainEventsData
import com.footballfan.networkutil.SomeResult
import com.footballfan.ui.football.events.model.UiEvent
import com.footballfan.ui.football.events.model.UiEventsData
import javax.inject.Inject

class EventsPresenter @Inject constructor(
    private val footballInteractor: FootballInteractor
) {
    suspend fun getEvents(fixtureID : String) : UiEventsData? = withIOContext {
        when(val response = footballInteractor.getEvents(fixtureID)){
            is SomeResult -> response.result.toUiEventsData()
            else -> null
        }
    }

    private fun DomainEventsData.toUiEventsData() : UiEventsData {
        return UiEventsData(
            events = events?.map {
                UiEvent(
                    time = it.time ?: -1,
                    teamID = it.teamID ?: -1,
                    teamName = it.teamName ?: "",
                    eventPlayerID = it.eventPlayerID ?: -1,
                    eventPlayerName = it.eventPlayerName ?: "",
                    eventAssistName = it.eventAssistName ?: "",
                    eventAssistID = it.eventAssistID ?: -1,
                    detail = it.detail ?: "",
                    type = it.type ?: ""
                )
            } ?: emptyList()
        )
    }
}