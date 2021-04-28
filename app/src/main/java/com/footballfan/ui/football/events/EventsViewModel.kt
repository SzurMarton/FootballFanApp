package com.footballfan.ui.football.events

import co.zsmb.rainbowcake.base.RainbowCakeViewModel
import javax.inject.Inject

class EventsViewModel @Inject constructor(
    private val eventsPresenter: EventsPresenter
) : RainbowCakeViewModel<EventsViewState>(Initial) {

    fun loadEvents(fixtureId: String) = execute {
        viewState = Loading
        val result = eventsPresenter.getEvents(fixtureId)
        viewState = result?.let { EventsReady(it) } ?: Error
    }
}