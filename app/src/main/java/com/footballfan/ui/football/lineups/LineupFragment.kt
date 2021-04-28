package com.footballfan.ui.football.lineups

import android.os.Bundle
import android.util.Log
import android.view.View
import co.zsmb.rainbowcake.base.RainbowCakeFragment
import co.zsmb.rainbowcake.dagger.getViewModelFromFactory
import co.zsmb.rainbowcake.navigation.extensions.applyArgs
import co.zsmb.rainbowcake.navigation.extensions.requireString
import com.footballfan.R
import com.footballfan.ui.football.fixturedetailmain.FixtureDetailMainFragment
import kotlinx.android.synthetic.main.fragment_lineup.*

class LineupFragment : RainbowCakeFragment<LineupViewState,LineupViewModel>() {
    companion object {
        private const val ARG_FIXTUREID = "ARG_FIXTUREID"

        fun newInstance(fixtureID: String): LineupFragment { //TODO shift to parentscope viewmodel and get data from there
            return LineupFragment().applyArgs {
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
        viewModel.loadLineup(fixtureID)
    }

    override fun provideViewModel() = getViewModelFromFactory()
    override fun getViewResource() = R.layout.fragment_lineup

    override fun render(viewState: LineupViewState) {
        when (viewState) {
            Loading -> viewFlipperLineup.displayedChild = 0
            is LineupReady -> {
                lineup.text = viewState.lineups.homeCoachName
                viewFlipperLineup.displayedChild = 1
            }
            Error -> viewFlipperLineup.displayedChild = 1
        }
    }

}