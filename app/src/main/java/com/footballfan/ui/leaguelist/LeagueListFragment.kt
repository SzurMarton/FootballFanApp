package com.footballfan.ui.leaguelist

import android.os.Bundle
import android.view.View
import co.zsmb.rainbowcake.base.RainbowCakeFragment
import co.zsmb.rainbowcake.dagger.getViewModelFromFactory
import co.zsmb.rainbowcake.navigation.navigator
import com.footballfan.R
import com.footballfan.ui.BlankFragment
import com.footballfan.ui.leaguelist.model.LeagueData
import kotlinx.android.synthetic.main.fragment_leaguelist.*
import kotlinx.android.synthetic.main.fragment_news.*

class LeagueListFragment : RainbowCakeFragment<LeagueListViewState,LeagueListViewModel>(), LeagueAdapter.Listener{
    override fun provideViewModel() = getViewModelFromFactory()
    override fun getViewResource() = R.layout.fragment_leaguelist
    private lateinit var leagueAdapter: LeagueAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        leagueAdapter = LeagueAdapter()
        leagueAdapter.listener = this
        leagueRecyclerView.adapter = leagueAdapter
    }

    override fun onStart() {
        super.onStart()
        viewModel.load()
    }

    override fun render(viewState: LeagueListViewState) {
        when(viewState){
            is Loading -> viewFlipperLeague.displayedChild = 0
            is LeagueListReady -> {
                leagueAdapter.submitList(viewState.leagueData.leagues)
                viewFlipperLeague.displayedChild = 1
            }
            is Error -> viewFlipperMain.displayedChild = 2
        }
    }

    override fun onLeagueClicked(league: LeagueData) {
        navigator?.add(BlankFragment())
    }

}