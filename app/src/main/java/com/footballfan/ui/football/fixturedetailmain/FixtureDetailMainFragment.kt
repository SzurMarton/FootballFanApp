package com.footballfan.ui.football.fixturedetailmain

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import co.zsmb.rainbowcake.base.RainbowCakeFragment
import co.zsmb.rainbowcake.dagger.getViewModelFromFactory
import co.zsmb.rainbowcake.navigation.extensions.applyArgs
import co.zsmb.rainbowcake.navigation.extensions.requireString
import com.bumptech.glide.Glide
import com.footballfan.R
import com.footballfan.ui.BlankFragment
import com.footballfan.ui.ViewPagerAdapter
import com.footballfan.ui.football.events.EventsFragment
import com.footballfan.ui.football.fixturelist.FixtureListFragment
import com.footballfan.ui.football.fixturelist.FixtureListViewState
import com.footballfan.ui.football.headtohead.HeadToHeadFragment
import com.footballfan.ui.football.leaguelist.LeagueListFragment
import com.footballfan.ui.football.leaguestandings.StandingsFragment
import com.footballfan.ui.football.lineups.LineupFragment
import com.footballfan.ui.football.stats.StatsFragment
import com.footballfan.ui.news.newslist.NewsFragment
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.fragment_fixturedetailmain.*
import kotlinx.android.synthetic.main.fragment_main.view.*
import kotlinx.android.synthetic.main.fragment_standings.*

class FixtureDetailMainFragment : RainbowCakeFragment<FixtureDetailMainViewState,FixtureDetailMainViewModel>(){
    companion object {
        private const val ARG_TEAM_AWAY_SCORE = "ARG_TEAM_AWAY_SCORE"
        private const val ARG_TEAM_HOME_SCORE = "ARG_TEAM_HOME_SCORE"
        private const val ARG_TEAM_AWAY_LOGO = "ARG_TEAM_AWAY_LOGO"
        private const val ARG_TEAM_HOME_LOGO = "ARG_TEAM_HOME_LOGO"
        private const val ARG_FIXTUREID = "ARG_FIXTUREID"
        private const val ARG_HomeTEAM_ID = "ARG_HomeTEAM_ID"
        private const val ARG_AwayTEAM_ID = "ARG_AwayTEAM_ID"

        fun newInstance(homeScore: String,awayScore :String,awayLogo: String,homeLogo: String,fixtureID: String,homeTeamID: String,awayTeamID: String): FixtureDetailMainFragment { //TODO shift to parentscope viewmodel and get data from there
            return FixtureDetailMainFragment().applyArgs {
                putString(ARG_TEAM_HOME_SCORE, homeScore)
                putString(ARG_TEAM_AWAY_SCORE, awayScore)
                putString(ARG_TEAM_AWAY_LOGO, awayLogo)
                putString(ARG_TEAM_HOME_LOGO, homeLogo)
                putString(ARG_FIXTUREID,fixtureID)
                putString(ARG_HomeTEAM_ID,homeTeamID)
                putString(ARG_AwayTEAM_ID,awayTeamID)
            }
        }
    }

    private lateinit var teamHomeScore : String
    private lateinit var teamAwayScore : String
    private lateinit var teamHomeLogo : String
    private lateinit var teamAwayLogo : String
    private lateinit var fixtureID : String
    private lateinit var homeTeamID : String
    private lateinit var awayTeamID : String

    private fun initArgs() { //TODO replace with parent scope viewmodel
        teamHomeScore = requireArguments().requireString(ARG_TEAM_HOME_SCORE)
        teamAwayScore = requireArguments().requireString(ARG_TEAM_AWAY_SCORE)
        teamAwayLogo = requireArguments().requireString(ARG_TEAM_AWAY_LOGO)
        teamHomeLogo = requireArguments().requireString(ARG_TEAM_HOME_LOGO)
        fixtureID = requireArguments().requireString(ARG_FIXTUREID)
        homeTeamID = requireArguments().requireString(ARG_HomeTEAM_ID)
        awayTeamID = requireArguments().requireString(ARG_AwayTEAM_ID)
    }

    override fun provideViewModel() = getViewModelFromFactory()
    override fun getViewResource() = R.layout.fragment_fixturedetailmain

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        initArgs()
        val view = inflater.inflate(R.layout.fragment_fixturedetailmain, container, false)
        initViewPager2WithFragments(view)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        teamHomeScoreText.text = teamHomeScore
        teamAwayScoreText.text = teamAwayScore
        Glide.with(teamHomeLogoImage)
                .load(teamHomeLogo)
                .into(teamHomeLogoImage)
        Glide.with(teamAwayLogoImage)
                .load(teamAwayLogo)
                .into(teamAwayLogoImage)
    }

    override fun render(viewState: FixtureDetailMainViewState) {
        when(viewState){
            is Initial -> {}
        }
    }

    private fun initViewPager2WithFragments(view: View){
        val adapter = ViewPagerAdapter(childFragmentManager, lifecycle)
        val lineupFragment = LineupFragment.newInstance(fixtureID)
        val eventFragment = EventsFragment.newInstance(fixtureID)
        val statFragment = StatsFragment.newInstance(fixtureID)
        val headToHeadFragment = HeadToHeadFragment.newInstance(homeTeamID,awayTeamID)
        adapter.fragments = arrayListOf(eventFragment, lineupFragment, statFragment,headToHeadFragment)
        view.viewpager.adapter = adapter
        val names:Array<String> = arrayOf("Events","Lineups","Stats","HeadToHead")
        TabLayoutMediator(view.tablayout, view.viewpager){
            tab, position ->
            tab.text = names[position]
        }.attach()
    }
}