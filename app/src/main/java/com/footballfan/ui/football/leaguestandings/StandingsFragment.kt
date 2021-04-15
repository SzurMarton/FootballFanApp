package com.footballfan.ui.football.leaguestandings

import android.os.Bundle
import android.util.Log
import android.view.View
import co.zsmb.rainbowcake.base.RainbowCakeFragment
import co.zsmb.rainbowcake.dagger.getViewModelFromFactory
import com.footballfan.R
import com.footballfan.ui.football.leaguestandings.model.UiStandingsAll
import kotlinx.android.synthetic.main.fragment_standings.*

class StandingsFragment : RainbowCakeFragment<StandingsViewState,StandingsViewModel>(), StandingsListALLAdapter.Listener{
    override fun provideViewModel() = getViewModelFromFactory()
    override fun getViewResource() = R.layout.fragment_standings
    private lateinit var standingsAdapter: StandingsListALLAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        standingsAdapter = StandingsListALLAdapter()
        standingsAdapter.listener = this
        StandingsListRecyclerView.adapter = standingsAdapter
    }

    override fun onStart() {
        super.onStart()
        viewModel.loadStandings(2020,78)
    }

    override fun render(viewState: StandingsViewState) {
        when(viewState){
            Loading -> viewFlipperStandingsList.displayedChild = 0
            is StandingsListReady -> {
                var standingsAll = viewState.standingsData.standingsAll
                standingsAdapter.submitList(standingsAll)
                viewFlipperStandingsList.displayedChild = 1
            }
            Error -> viewFlipperStandingsList.displayedChild = 2
        }
    }

    override fun onTeamClicked(team: UiStandingsAll) {
        TODO("Not yet implemented")
    }
}