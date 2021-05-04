package com.footballfan.ui.football.fixturelist

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import co.zsmb.rainbowcake.base.RainbowCakeFragment
import co.zsmb.rainbowcake.dagger.getViewModelFromFactory
import co.zsmb.rainbowcake.navigation.extensions.applyArgs
import co.zsmb.rainbowcake.navigation.extensions.requireString
import co.zsmb.rainbowcake.navigation.navigator
import com.bumptech.glide.Glide
import com.footballfan.R
import com.footballfan.ui.BlankFragment
import com.footballfan.ui.football.fixturedetailmain.FixtureDetailMainFragment
import com.footballfan.ui.football.fixturelist.model.FixtureListUiData
import kotlinx.android.synthetic.main.fragment_fixturelist.*
import kotlinx.android.synthetic.main.fragment_fixturelist.spinner
import kotlinx.android.synthetic.main.fragment_fixturelist.teamLogo
import kotlinx.android.synthetic.main.fragment_fixturelist.teamName

class FixtureListFragment : RainbowCakeFragment<FixtureListViewState,FixtureListViewModel>(),FixtureListAdapter.Listener, AdapterView.OnItemSelectedListener{
    companion object {
        private const val ARG_LEAGUE_ID = "ARG_LEAGUE_ID"
        private const val ARG_LEAGUE_NAME = "ARG_LEAGUE_NAME"
        private const val ARG_LEAGUE_LOGO = "ARG_LEAGUE_LOGO"

        fun newInstance(leagueID: String,leagueName: String,leagueLogo: String): FixtureListFragment { //TODO shift to parentscope viewmodel and get data from there
            return FixtureListFragment().applyArgs {
                putString(ARG_LEAGUE_ID, leagueID)
                putString(ARG_LEAGUE_NAME,leagueName)
                putString(ARG_LEAGUE_LOGO,leagueLogo)
            }
        }
    }

    private var leagueID: Int = 0
    private var rounds :List<String>? =null
    private lateinit var leagueName: String
    private lateinit var leagueLogo: String
    private lateinit var fixtureListAdapter: FixtureListAdapter

    override fun provideViewModel() = getViewModelFromFactory()
    override fun getViewResource() = R.layout.fragment_fixturelist

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fixtureListAdapter = FixtureListAdapter()
        fixtureListAdapter.listener = this
        FixtureListRecyclerView.adapter = fixtureListAdapter
        spinner.onItemSelectedListener = this
        initArgs()

        teamName.text = leagueName
        Glide.with(teamLogo)
                .load(leagueLogo)
                .into(teamLogo)
    }

    override fun onStart() {
        super.onStart()
        viewModel.loadFixturesData(leagueID)
    }

    private fun initArgs() { //TODO replace with parent scope viewmodel
        leagueID = requireArguments().requireString(FixtureListFragment.ARG_LEAGUE_ID).toInt()
        leagueName = requireArguments().requireString(ARG_LEAGUE_NAME)
        leagueLogo = requireArguments().requireString(ARG_LEAGUE_LOGO)
    }

    override fun render(viewState: FixtureListViewState) {
        when(viewState){
            is Loading -> viewFlipperFixtureList.displayedChild = 0
            is DataReady -> {
                rounds = viewState.rounds.rounds
                val options = ArrayList<String>(rounds)
                spinner.adapter = activity?.let { ArrayAdapter<String>(it, android.R.layout.simple_spinner_item, options ) }
                val fixtures = viewState.fixtureListData.fixtures
                fixtureListAdapter.submitList(fixtures)
                viewFlipperFixtureList.displayedChild = 1
            }
            is com.footballfan.ui.football.fixturelist.Error -> viewFlipperFixtureList.displayedChild = 2
        }
    }

    override fun onFixtureClicked(fixture: FixtureListUiData) {
        Log.d("asd",fixture.fixtureID.toString())
        navigator?.add(FixtureDetailMainFragment.newInstance(fixture.homeGoals,fixture.awayGoals,
                fixture.awayTeamLogo,fixture.homeTeamLogo,fixture.fixtureID.toString(),
                fixture.homeTeamID.toString(),fixture.awayTeamID.toString()
        ))
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        //display all fixtures
        fixtureListAdapter.submitList(viewModel.getAllFixtures())
        fixtureListAdapter.notifyDataSetChanged()
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        val list = viewModel.getFilteredFixtures(rounds?.get(position))
        fixtureListAdapter.submitList(list)
        fixtureListAdapter.notifyDataSetChanged()
    }
}