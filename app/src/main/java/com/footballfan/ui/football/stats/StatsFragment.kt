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
        //Log.d("asd", fixtureID)
    }

    override fun onStart() {
        super.onStart()
        viewModel.loadStats(fixtureID)
        //viewModel.loadStats("587176")
    }

    override fun provideViewModel() = getViewModelFromFactory()
    override fun getViewResource() = R.layout.fragment_stats

    override fun render(viewState: StatsViewState) {
        when(viewState){
            Loading -> viewFlipperStats.displayedChild = 0
            is StatsReady -> {
                homeShotsonGoal.text = viewState.stats.homeTeamStats.statistics[0].value
                awayShotsonGoal.text = viewState.stats.awayTeamStats.statistics[0].value
                pbSOGHome.max = viewState.stats.homeTeamStats.statistics[0].value.toInt()+viewState.stats.awayTeamStats.statistics[0].value.toInt()
                pbSOGAway.max = viewState.stats.homeTeamStats.statistics[0].value.toInt()+viewState.stats.awayTeamStats.statistics[0].value.toInt()
                pbSOGHome.progress = viewState.stats.homeTeamStats.statistics[0].value.toInt()
                pbSOGAway.progress = viewState.stats.awayTeamStats.statistics[0].value.toInt()
                //TODO replace with better ui data class
                homeShotsoffGoal.text = viewState.stats.homeTeamStats.statistics[1].value
                awayShotsoffGoal.text = viewState.stats.awayTeamStats.statistics[1].value
                pbSOFFHome.max = viewState.stats.homeTeamStats.statistics[1].value.toInt()+viewState.stats.awayTeamStats.statistics[1].value.toInt()
                pbSOFFAway.max = viewState.stats.homeTeamStats.statistics[1].value.toInt()+viewState.stats.awayTeamStats.statistics[1].value.toInt()
                pbSOFFHome.progress = viewState.stats.homeTeamStats.statistics[1].value.toInt()
                pbSOFFAway.progress = viewState.stats.awayTeamStats.statistics[1].value.toInt()

                homeTotalShots.text = viewState.stats.homeTeamStats.statistics[2].value
                awayTotalShots.text = viewState.stats.awayTeamStats.statistics[2].value
                pbTotalHome.max = viewState.stats.homeTeamStats.statistics[2].value.toInt()+viewState.stats.awayTeamStats.statistics[2].value.toInt()
                pbTotalAway.max = viewState.stats.homeTeamStats.statistics[2].value.toInt()+viewState.stats.awayTeamStats.statistics[2].value.toInt()
                pbTotalHome.progress = viewState.stats.homeTeamStats.statistics[2].value.toInt()
                pbTotalAway.progress = viewState.stats.awayTeamStats.statistics[2].value.toInt()

                homeBlockedShots.text = viewState.stats.homeTeamStats.statistics[3].value
                awayBlockedShots.text = viewState.stats.awayTeamStats.statistics[3].value
                pbBlockedHome.max = viewState.stats.homeTeamStats.statistics[3].value.toInt()+viewState.stats.awayTeamStats.statistics[3].value.toInt()
                pbBlockedAway.max = viewState.stats.homeTeamStats.statistics[3].value.toInt()+viewState.stats.awayTeamStats.statistics[3].value.toInt()
                pbBlockedHome.progress = viewState.stats.homeTeamStats.statistics[3].value.toInt()
                pbBlockedAway.progress = viewState.stats.awayTeamStats.statistics[3].value.toInt()

                homeFouls.text = viewState.stats.homeTeamStats.statistics[6].value
                awayFouls.text = viewState.stats.awayTeamStats.statistics[6].value
                pbFoulsHome.max = viewState.stats.homeTeamStats.statistics[6].value.toInt()+viewState.stats.awayTeamStats.statistics[6].value.toInt()
                pbFoulsAway.max = viewState.stats.homeTeamStats.statistics[6].value.toInt()+viewState.stats.awayTeamStats.statistics[6].value.toInt()
                pbFoulsHome.progress = viewState.stats.homeTeamStats.statistics[6].value.toInt()
                pbFoulsAway.progress = viewState.stats.awayTeamStats.statistics[6].value.toInt()
                
                homeCorners.text = viewState.stats.homeTeamStats.statistics[7].value
                awayCorners.text = viewState.stats.awayTeamStats.statistics[7].value
                pbCornersHome.max = viewState.stats.homeTeamStats.statistics[7].value.toInt()+viewState.stats.awayTeamStats.statistics[7].value.toInt()
                pbCornersAway.max = viewState.stats.homeTeamStats.statistics[7].value.toInt()+viewState.stats.awayTeamStats.statistics[7].value.toInt()
                pbCornersHome.progress = viewState.stats.homeTeamStats.statistics[7].value.toInt()
                pbCornersAway.progress = viewState.stats.awayTeamStats.statistics[7].value.toInt()

                homeOffsides.text = viewState.stats.homeTeamStats.statistics[8].value
                awayOffsides.text = viewState.stats.awayTeamStats.statistics[8].value
                pbOffsidesHome.max = viewState.stats.homeTeamStats.statistics[8].value.toInt()+viewState.stats.awayTeamStats.statistics[8].value.toInt()
                pbOffsidesAway.max = viewState.stats.homeTeamStats.statistics[8].value.toInt()+viewState.stats.awayTeamStats.statistics[8].value.toInt()
                pbOffsidesHome.progress = viewState.stats.homeTeamStats.statistics[8].value.toInt()
                pbOffsidesAway.progress = viewState.stats.awayTeamStats.statistics[8].value.toInt()

                homeBallPossession.text = viewState.stats.homeTeamStats.statistics[9].value
                awayBallPossession.text = viewState.stats.awayTeamStats.statistics[9].value
                pbPossessionHome.max = viewState.stats.homeTeamStats.statistics[9].value.dropLast(1).toInt()+viewState.stats.awayTeamStats.statistics[9].value.dropLast(1).toInt()
                pbPossessionAway.max = viewState.stats.homeTeamStats.statistics[9].value.dropLast(1).toInt()+viewState.stats.awayTeamStats.statistics[9].value.dropLast(1).toInt()
                pbPossessionHome.progress = viewState.stats.homeTeamStats.statistics[9].value.dropLast(1).toInt()
                pbPossessionAway.progress = viewState.stats.awayTeamStats.statistics[9].value.dropLast(1).toInt()
//              
                homeYellows.text = viewState.stats.homeTeamStats.statistics[10].value
                awayYellows.text = viewState.stats.awayTeamStats.statistics[10].value
                pbYellowsHome.max = viewState.stats.homeTeamStats.statistics[10].value.toInt()+viewState.stats.awayTeamStats.statistics[10].value.toInt()
                pbYellowsAway.max = viewState.stats.homeTeamStats.statistics[10].value.toInt()+viewState.stats.awayTeamStats.statistics[10].value.toInt()
                pbYellowsHome.progress = viewState.stats.homeTeamStats.statistics[10].value.toInt()
                pbYellowsAway.progress = viewState.stats.awayTeamStats.statistics[10].value.toInt()
//              
                homeReds.text = viewState.stats.homeTeamStats.statistics[11].value
                awayReds.text = viewState.stats.awayTeamStats.statistics[11].value
                pbRedsHome.max = viewState.stats.homeTeamStats.statistics[11].value.toInt()+viewState.stats.awayTeamStats.statistics[11].value.toInt()
                pbRedsAway.max = viewState.stats.homeTeamStats.statistics[11].value.toInt()+viewState.stats.awayTeamStats.statistics[11].value.toInt()
                pbRedsHome.progress = viewState.stats.homeTeamStats.statistics[11].value.toInt()
                pbRedsAway.progress = viewState.stats.awayTeamStats.statistics[11].value.toInt()

                viewFlipperStats.displayedChild = 1
            }
            Error -> viewFlipperStats.displayedChild = 2 //Show error
        }
    }
}