package com.footballfan.ui.football.stats

import android.os.Bundle
import android.util.Log
import android.view.View
import co.zsmb.rainbowcake.base.RainbowCakeFragment
import co.zsmb.rainbowcake.dagger.getViewModelFromFactory
import co.zsmb.rainbowcake.navigation.extensions.applyArgs
import co.zsmb.rainbowcake.navigation.extensions.requireString
import com.footballfan.R
import kotlinx.android.synthetic.main.fragment_stats.*

class StatsFragment : RainbowCakeFragment<StatsViewState,StatsViewModel>(){
    companion object {
        private const val ARG_FIXTUREID = "ARG_FIXTUREID"

        fun newInstance(fixtureID: String): StatsFragment { //TODO shift to parentscope viewmodel and get data from there
            return StatsFragment().applyArgs {
                putString(ARG_FIXTUREID,fixtureID)
            }
        }
    }

    private lateinit var fixtureID : String

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initArgs()
    }

    private fun initArgs() { //TODO replace with parent scope viewmodel
        fixtureID = requireArguments().requireString(ARG_FIXTUREID)
        Log.d("asd", fixtureID)
    }

    override fun onStart() {
        super.onStart()
        viewModel.loadStats(fixtureID)
    }

    override fun provideViewModel() = getViewModelFromFactory()
    override fun getViewResource() = R.layout.fragment_stats

    override fun render(viewState: StatsViewState) {
        when(viewState){
            Loading -> viewFlipperStats.displayedChild = 0
            is StatsReady -> {
                stats.text = viewState.stats.awayTeamStats.teamID.toString()
                viewFlipperStats.displayedChild = 1
            }
            Error -> viewFlipperStats.displayedChild = 1 //Show error
        }
    }
}