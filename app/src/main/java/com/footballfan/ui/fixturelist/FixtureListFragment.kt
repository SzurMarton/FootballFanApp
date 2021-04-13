package com.footballfan.ui.fixturelist

import android.os.Bundle
import android.util.Log
import android.view.View
import co.zsmb.rainbowcake.base.RainbowCakeFragment
import co.zsmb.rainbowcake.dagger.getViewModelFromFactory
import co.zsmb.rainbowcake.navigation.extensions.applyArgs
import co.zsmb.rainbowcake.navigation.extensions.requireString
import com.footballfan.R
import com.footballfan.ui.fixturelist.model.FixtureListUiData
import com.footballfan.ui.leaguedetailmain.DetailMainFragment
import com.footballfan.ui.leaguelist.Error
import kotlinx.android.synthetic.main.fragment_fixturelist.*
import kotlinx.android.synthetic.main.fragment_news.*

class FixtureListFragment : RainbowCakeFragment<FixtureListViewState,FixtureListViewModel>(),FixtureListAdapter.Listener{
    companion object {
        private const val ARG_LEAGUE_ID = "ARG_LEAGUE_ID"

        fun newInstance(leagueID: String): DetailMainFragment {
            return DetailMainFragment().applyArgs {
                putString(ARG_LEAGUE_ID, leagueID)
            }
        }
    }

    private var leagueID: Int = 78
    private lateinit var fixtureListAdapter: FixtureListAdapter
    override fun provideViewModel() = getViewModelFromFactory()
    override fun getViewResource() = R.layout.fragment_fixturelist

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fixtureListAdapter = FixtureListAdapter()
        fixtureListAdapter.listener = this
        FixtureListRecyclerView.adapter = fixtureListAdapter
        initArgs()
    }

    override fun onStart() {
        super.onStart()
        viewModel.loadFixtures(leagueID)
    }

    private fun initArgs() {
        leagueID = requireArguments().requireString(FixtureListFragment.ARG_LEAGUE_ID).toInt()
        Log.d("asd",leagueID.toString())
    }

    override fun render(viewState: FixtureListViewState) {
        when(viewState){
            is Loading -> viewFlipperFixtureList.displayedChild = 0
            is FixtureListReady -> {
                var fixtures = viewState.fixtureListData.fixtures
                Log.d("asd",fixtures?.size.toString())
                fixtureListAdapter.submitList(fixtures)
                viewFlipperFixtureList.displayedChild = 1
            }
            is com.footballfan.ui.fixturelist.Error -> viewFlipperFixtureList.displayedChild = 2
        }
    }

    override fun onFixtureClicked(fixture: FixtureListUiData) {
        TODO("Not yet implemented")
    }

}