package com.footballfan.ui.football.headtohead

import android.os.Bundle
import android.util.Log
import android.view.View
import co.zsmb.rainbowcake.base.RainbowCakeFragment
import co.zsmb.rainbowcake.dagger.getViewModelFromFactory
import co.zsmb.rainbowcake.navigation.extensions.applyArgs
import co.zsmb.rainbowcake.navigation.extensions.requireString
import com.footballfan.R
import com.footballfan.ui.football.stats.StatsFragment
import kotlinx.android.synthetic.main.fragment_headtohead.*

class HeadToHeadFragment : RainbowCakeFragment<HeadToHeadViewState,HeadToHeadViewModel>() {
    companion object {
        private const val ARG_FIXTUREID = "ARG_FIXTUREID"

        fun newInstance(fixtureID: String): HeadToHeadFragment { //TODO shift to parentscope viewmodel and get data from there
            return HeadToHeadFragment().applyArgs {
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

    override fun provideViewModel() = getViewModelFromFactory()
    override fun getViewResource() = R.layout.fragment_headtohead

    override fun render(viewState: HeadToHeadViewState) {
        when(viewState){
            Loading -> viewFlipperHeadToHead.displayedChild = 0
            is HeadToHeadReady -> {
                viewFlipperHeadToHead.displayedChild = 1
            }
            Error -> viewFlipperHeadToHead.displayedChild = 1
        }
    }

}