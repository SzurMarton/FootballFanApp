package com.footballfan.ui.football.leaguedetailmain

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import co.zsmb.rainbowcake.base.RainbowCakeFragment
import co.zsmb.rainbowcake.dagger.getViewModelFromFactory
import co.zsmb.rainbowcake.navigation.extensions.applyArgs
import co.zsmb.rainbowcake.navigation.extensions.requireString
import com.footballfan.R
import com.footballfan.ui.BlankFragment
import com.footballfan.ui.ViewPagerAdapter
import com.footballfan.ui.football.fixturelist.FixtureListFragment
import com.footballfan.ui.football.leaguestandings.StandingsFragment
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.fragment_main.view.*

class DetailMainFragment : RainbowCakeFragment<DetailMainViewState, DetailMainViewModel>() {
    companion object {
        private const val ARG_LEAGUE_ID = "ARG_LEAGUE_ID"
        private const val ARG_LEAGUE_NAME = "ARG_LEAGUE_NAME"
        private const val ARG_LEAGUE_LOGO = "ARG_LEAGUE_LOGO"


        fun newInstance(leagueID: String, leagueName: String, leagueLogo: String): DetailMainFragment {
            return DetailMainFragment().applyArgs {
                putString(ARG_LEAGUE_ID, leagueID)
                putString(ARG_LEAGUE_NAME, leagueName)
                putString(ARG_LEAGUE_LOGO, leagueLogo)
            }
        }
    }

    private var leagueID: Int = 0
    private lateinit var leagueName: String
    private lateinit var leagueLogo: String
    override fun provideViewModel(): DetailMainViewModel = getViewModelFromFactory()
    override fun getViewResource(): Int = R.layout.fragment_leaguemaindetails


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initArgs()
    }

    private fun initArgs() {
        leagueID = requireArguments().requireString(ARG_LEAGUE_ID).toInt()
        leagueName = requireArguments().requireString(ARG_LEAGUE_NAME)
        leagueLogo = requireArguments().requireString(ARG_LEAGUE_LOGO)
        Log.d("asd", leagueID.toString() + "hello from initargs detail")
    }

    override fun render(viewState: DetailMainViewState) {
        when (viewState) {
            Initial -> {
                Log.d("asd", leagueID.toString() + "hello from detail")
            }
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        initArgs()
        val view = inflater.inflate(R.layout.fragment_leaguemaindetails, container, false)
        initViewPager2WithFragments(view)
        return view
    }

    private fun initViewPager2WithFragments(view: View) {
        val adapter = ViewPagerAdapter(childFragmentManager, lifecycle)
        val fixtureListFragment = FixtureListFragment.newInstance(leagueID.toString(), leagueName, leagueLogo)
        val standingsFragment = StandingsFragment.newInstance(leagueID.toString(), leagueName, leagueLogo)
        adapter.fragments = arrayListOf(fixtureListFragment, standingsFragment, BlankFragment())
        view.viewpager.adapter = adapter
        val names: Array<String> = arrayOf(getString(R.string.matches), getString(R.string.leagueTable), "LeagueRelatedforum??")
        TabLayoutMediator(view.tablayout, view.viewpager) { tab, position ->
            tab.text = names[position]
        }.attach()
    }
}
