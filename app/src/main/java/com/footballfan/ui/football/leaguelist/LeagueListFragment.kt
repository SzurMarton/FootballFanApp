package com.footballfan.ui.football.leaguelist

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import co.zsmb.rainbowcake.base.RainbowCakeFragment
import co.zsmb.rainbowcake.dagger.getViewModelFromFactory
import co.zsmb.rainbowcake.navigation.navigator
import com.footballfan.R
import com.footballfan.ui.football.leaguedetailmain.DetailMainFragment
import com.footballfan.ui.football.leaguelist.model.LeagueData
import kotlinx.android.synthetic.main.fragment_leaguelist.*
import kotlinx.android.synthetic.main.fragment_news.*

class LeagueListFragment : RainbowCakeFragment<LeagueListViewState, LeagueListViewModel>(), ListAdapter.OnLeagueSelectedListener {
    override fun provideViewModel() = getViewModelFromFactory()
    override fun getViewResource() = R.layout.fragment_leaguelist
    private lateinit var leagueAdapter: ListAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()

        leagueSearch.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                leagueAdapter.filter.filter(newText)
                return false
            }

        })
    }

    private fun initRecyclerView() {
        leagueRecyclerView.layoutManager = LinearLayoutManager(activity)
        leagueAdapter = ListAdapter(this)
        leagueRecyclerView.adapter = leagueAdapter
    }

    override fun onStart() {
        super.onStart()
        viewModel.load()
    }

    override fun render(viewState: LeagueListViewState) {
        when (viewState) {
            is Loading -> viewFlipperLeague.displayedChild = 0
            is LeagueListReady -> {
                var leauges = viewState.leagueData.leagues
                if (leagueAdapter.itemCount == 0) {
                    if (leauges != null) {
                        for (i in leauges.indices) {
                            leagueAdapter.addLeague(leauges[i])
                        }
                    }
                }
                viewFlipperLeague.displayedChild = 1
            }
            is Error -> viewFlipperMain.displayedChild = 2
        }
    }

    override fun onLeagueSelected(league: LeagueData?) {
        Log.d("asd", league?.id.toString())
        navigator?.add(DetailMainFragment.newInstance(league?.id.toString(),league?.name ?: "", league?.logo ?: ""))
    }
}


