package com.footballfan.ui.football.leaguestandings

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import co.zsmb.rainbowcake.base.RainbowCakeFragment
import co.zsmb.rainbowcake.dagger.getViewModelFromFactory
import co.zsmb.rainbowcake.navigation.extensions.applyArgs
import co.zsmb.rainbowcake.navigation.extensions.requireString
import com.bumptech.glide.Glide
import com.footballfan.R
import com.footballfan.ui.football.fixturelist.FixtureListFragment
import com.footballfan.ui.football.leaguestandings.model.UiStandingsAll
import com.footballfan.ui.football.leaguestandings.model.UiStandingsAway
import com.footballfan.ui.football.leaguestandings.model.UiStandingsHome
import kotlinx.android.synthetic.main.fragment_fixturelist.*
import kotlinx.android.synthetic.main.fragment_standings.*
import kotlinx.android.synthetic.main.fragment_standings.spinner
import kotlinx.android.synthetic.main.fragment_standings.teamLogo
import kotlinx.android.synthetic.main.fragment_standings.teamName

class StandingsFragment : RainbowCakeFragment<StandingsViewState, StandingsViewModel>(), AdapterView.OnItemSelectedListener, StandingsListALLAdapter.Listener, SatndingsListaAwayAdapter.Listener, StandingsListHomeAdapter.Listener {
    companion object {
        private const val ARG_LEAGUE_ID = "ARG_LEAGUE_ID"
        private const val ARG_LEAGUE_NAME = "ARG_LEAGUE_NAME"
        private const val ARG_LEAGUE_LOGO = "ARG_LEAGUE_LOGO"

        fun newInstance(leagueID: String, leagueName: String, leagueLogo: String): StandingsFragment { //TODO shift to parentscope viewmodel and get data from there
            return StandingsFragment().applyArgs {
                putString(ARG_LEAGUE_ID, leagueID)
                putString(ARG_LEAGUE_NAME, leagueName)
                putString(ARG_LEAGUE_LOGO, leagueLogo)
            }
        }
    }

    private var leagueID: Int = 0
    private lateinit var leagueName: String
    private lateinit var leagueLogo: String

    override fun provideViewModel() = getViewModelFromFactory()
    override fun getViewResource() = R.layout.fragment_standings
    private lateinit var standingsAdapter: StandingsListALLAdapter
    private lateinit var standingsListHomeAdapter: StandingsListHomeAdapter
    private lateinit var satndingsListaAwayAdapter: SatndingsListaAwayAdapter
    private var options: ArrayList<String> = arrayListOf("All", "Home", "Away") //TODO extract to string resource
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
                activity?.let { ArrayAdapter<String>(it, android.R.layout.simple_spinner_item, options) }
        spinner.onItemSelectedListener = this

        initArgs()
        teamName.text = leagueName
        Glide.with(teamLogo)
                .load(leagueLogo)
                .into(teamLogo)
    }

    private fun initArgs() {
        leagueID = requireArguments().requireString(ARG_LEAGUE_ID).toInt()
        leagueName = requireArguments().requireString(ARG_LEAGUE_NAME)
        leagueLogo = requireArguments().requireString(ARG_LEAGUE_LOGO)
    }

    override fun onStart() {
        super.onStart()
        viewModel.loadStandings(2020, leagueID)
    }

    //TODO Handle cups and leagues with group stages
    override fun render(viewState: StandingsViewState) {
        when (viewState) {
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
        TODO("Navigate to team details")
    }

    override fun onTeamAwayClicked(team: UiStandingsAway) {
        TODO("Navigate to team details")
    }

    override fun onTeamHomeClicked(team: UiStandingsHome) {
        TODO("Navigate to team details")
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        TODO("Not yet implemented")
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        val item = options[position]
        if (item == "All") {
            viewFlipperStandingsList.displayedChild = 0
        }
        if (item == "Home") {
            viewFlipperStandingsList.displayedChild = 1
        }
        if (item == "Away") {
            viewFlipperStandingsList.displayedChild = 2
        }
    }
}