package com.footballfan.ui.football.leaguestandings

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import co.zsmb.rainbowcake.base.RainbowCakeFragment
import co.zsmb.rainbowcake.dagger.getViewModelFromFactory
import com.footballfan.R
import com.footballfan.ui.football.leaguestandings.model.UiStandingsAll
import com.footballfan.ui.football.leaguestandings.model.UiStandingsAway
import com.footballfan.ui.football.leaguestandings.model.UiStandingsHome
import kotlinx.android.synthetic.main.fragment_standings.*

class StandingsFragment : RainbowCakeFragment<StandingsViewState,StandingsViewModel>(), AdapterView.OnItemSelectedListener, StandingsListALLAdapter.Listener, SatndingsListaAwayAdapter.Listener,StandingsListHomeAdapter.Listener{
    override fun provideViewModel() = getViewModelFromFactory()
    override fun getViewResource() = R.layout.fragment_standings
    private lateinit var standingsAdapter: StandingsListALLAdapter
    private lateinit var standingsListHomeAdapter: StandingsListHomeAdapter
    private lateinit var satndingsListaAwayAdapter: SatndingsListaAwayAdapter
    private var options : ArrayList<String> = arrayListOf("All","Home","Away") //TODO extract to string resource
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        standingsAdapter = StandingsListALLAdapter()
        standingsListHomeAdapter = StandingsListHomeAdapter()
        satndingsListaAwayAdapter = SatndingsListaAwayAdapter()
        standingsAdapter.listener = this
        standingsListHomeAdapter.listener = this
        satndingsListaAwayAdapter.listener = this
        StandingsListRecyclerView.adapter = standingsAdapter
        StandingsListHomeRecyclerView.adapter = standingsListHomeAdapter
        StandingsListAwayRecyclerView.adapter = satndingsListaAwayAdapter

        spinner.adapter =
                activity?.let { ArrayAdapter<String>(it,android.R.layout.simple_spinner_item,options) }
        spinner.onItemSelectedListener = this
    }

    override fun onStart() {
        super.onStart()
        viewModel.loadStandings(2020,78)
    }

    override fun render(viewState: StandingsViewState) {
        when(viewState){
            Loading -> viewFlipperStandingsMain.displayedChild = 0
            is StandingsListReady -> {
                val standingsAll = viewState.standingsData.standingsAll
                val standingsHome = viewState.standingsData.standingsHome.sortedByDescending { it.homePoints }
                val standingsAway = viewState.standingsData.standingsAway.sortedByDescending { it.awayPoints }
                standingsAdapter.submitList(standingsAll)
                standingsListHomeAdapter.submitList(standingsHome)
                satndingsListaAwayAdapter.submitList(standingsAway)
                viewFlipperStandingsMain.displayedChild = 1
                viewFlipperStandingsList.displayedChild = 0
            }
            Error -> viewFlipperStandingsList.displayedChild = 4
        }
    }

    override fun onTeamClicked(team: UiStandingsAll) {
        TODO("Not yet implemented")
    }

    override fun onTeamAwayClicked(team: UiStandingsAway) {
        TODO("Not yet implemented")
    }

    override fun onTeamHomeClicked(team: UiStandingsHome) {
        TODO("Not yet implemented")
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        TODO("Not yet implemented")
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        val item = options[position]
        if(item == "All"){
            viewFlipperStandingsList.displayedChild = 0
        }
        if(item == "Home"){
            viewFlipperStandingsList.displayedChild = 1
        }
        if(item == "Away"){
            viewFlipperStandingsList.displayedChild = 2
        }
    }
}