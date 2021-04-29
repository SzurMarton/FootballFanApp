package com.footballfan.ui.football.headtohead

import android.os.Bundle
import android.util.Log
import android.view.View
import co.zsmb.rainbowcake.base.RainbowCakeFragment
import co.zsmb.rainbowcake.dagger.getViewModelFromFactory
import co.zsmb.rainbowcake.navigation.extensions.applyArgs
import co.zsmb.rainbowcake.navigation.extensions.requireString
import com.footballfan.R
import com.footballfan.ui.football.headtohead.model.UiH2HFixture
import com.footballfan.ui.football.stats.StatsFragment
import kotlinx.android.synthetic.main.fragment_headtohead.*

class HeadToHeadFragment : RainbowCakeFragment<HeadToHeadViewState,HeadToHeadViewModel>(), HeadToHeadListAdapter.Listener {
    companion object {
        private const val ARG_HomeTEAM_ID = "ARG_HomeTEAM_ID"
        private const val ARG_AwayTEAM_ID = "ARG_AwayTEAM_ID"

        fun newInstance(homeTeamID: String,awayTeamID: String): HeadToHeadFragment { //TODO shift to parentscope viewmodel and get data from there
            return HeadToHeadFragment().applyArgs {
                putString(ARG_HomeTEAM_ID,homeTeamID)
                putString(ARG_AwayTEAM_ID,awayTeamID)
            }
        }
    }

    private lateinit var homeTeamID : String
    private lateinit var awayTeamID : String
    private lateinit var headToHeadListAdapter: HeadToHeadListAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        headToHeadListAdapter = HeadToHeadListAdapter()
        headToHeadListAdapter.listener = this
        H2HListRecyclerView.adapter = headToHeadListAdapter
        initArgs()
    }

    override fun onStart() {
        super.onStart()
        viewModel.loadHeadToHead(homeTeamID,awayTeamID)
    }

    private fun initArgs() { //TODO replace with parent scope viewmodel
        homeTeamID = requireArguments().requireString(ARG_HomeTEAM_ID)
        awayTeamID = requireArguments().requireString(ARG_AwayTEAM_ID)
    }

    override fun provideViewModel() = getViewModelFromFactory()
    override fun getViewResource() = R.layout.fragment_headtohead

    override fun render(viewState: HeadToHeadViewState) {
        when(viewState){
            Loading -> viewFlipperHeadToHead.displayedChild = 0
            is HeadToHeadReady -> {
                val h2HFixtures = viewState.h2hFixtures.h2hfixtures.sortedBy { it.date }
                headToHeadListAdapter.submitList(h2HFixtures)
                viewFlipperHeadToHead.displayedChild = 1
            }
            Error -> viewFlipperHeadToHead.displayedChild = 2
        }
    }

    override fun onFixtureClicked(fixture: UiH2HFixture) {
        TODO("Not yet implemented")
    }

}