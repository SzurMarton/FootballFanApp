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
import com.bumptech.glide.Glide
import com.footballfan.R
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

    private fun initArgs() {
        leagueID = requireArguments().requireString(FixtureListFragment.ARG_LEAGUE_ID).toInt()
        leagueName = requireArguments().requireString(ARG_LEAGUE_NAME)
        leagueLogo = requireArguments().requireString(ARG_LEAGUE_LOGO)
        Log.d("asd",leagueID.toString() + "hello from fixturelist initargs")
    }

    override fun render(viewState: FixtureListViewState) {
        when(viewState){
            is Loading -> viewFlipperFixtureList.displayedChild = 0
            is DataReady -> {
                var rounds = viewState.rounds.rounds
                spinner.adapter = activity?.let { ArrayAdapter<String>(it, android.R.layout.simple_spinner_item, ArrayList<String>(rounds)) }
                var fixtures = viewState.fixtureListData.fixtures
                Log.d("asd",fixtures?.size.toString())
                fixtureListAdapter.submitList(fixtures)
                viewFlipperFixtureList.displayedChild = 1
            }
            is com.footballfan.ui.football.fixturelist.Error -> viewFlipperFixtureList.displayedChild = 2
        }
    }

    override fun onFixtureClicked(fixture: FixtureListUiData) {
        TODO("Navigate to fixturedetails")
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        TODO("Not yet implemented")
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        //TODO filter fixture list
        Log.d("asd","sda")
    }

}