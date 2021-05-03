package com.footballfan.ui.football.events

import android.os.Bundle
import android.util.Log
import android.view.View
import co.zsmb.rainbowcake.base.RainbowCakeFragment
import co.zsmb.rainbowcake.dagger.getViewModelFromFactory
import co.zsmb.rainbowcake.navigation.extensions.applyArgs
import co.zsmb.rainbowcake.navigation.extensions.requireString
import com.footballfan.R
import com.footballfan.ui.football.lineups.LineupFragment
import kotlinx.android.synthetic.main.fragment_events.*

class EventsFragment : RainbowCakeFragment<EventsViewState,EventsViewModel>() {
    companion object {
        private const val ARG_FIXTUREID = "ARG_FIXTUREID"

        fun newInstance(fixtureID: String): EventsFragment { //TODO shift to parentscope viewmodel and get data from there
            return EventsFragment().applyArgs {
                putString(ARG_FIXTUREID,fixtureID)
            }
        }
    }

    private lateinit var fixtureID : String
    private lateinit var eventAdapter :  EventListAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        eventAdapter = EventListAdapter()
        eventListRecyclerView.adapter = eventAdapter
        initArgs()
    }

    private fun initArgs() { //TODO replace with parent scope viewmodel
        fixtureID = requireArguments().requireString(ARG_FIXTUREID)
    }

    override fun onStart() {
        super.onStart()
        viewModel.loadEvents(fixtureID)
    }

    override fun provideViewModel() = getViewModelFromFactory()
    override fun getViewResource() = R.layout.fragment_events

    override fun render(viewState: EventsViewState) {
        when(viewState) {
            Loading -> viewFlipperEvents.displayedChild = 0
            is EventsReady -> {
                //event.text = viewState.events.events.first().type
                eventAdapter.submitList(viewState.events.events)
                viewFlipperEvents.displayedChild = 1
            }
            Error -> viewFlipperEvents.displayedChild = 2
        }
    }
}