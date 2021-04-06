package com.footballfan.ui.leaguedetailmain

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
import com.footballfan.ui.deatilnews.DetailNewsFragment
import com.footballfan.ui.leaguelist.LeagueListFragment
import com.footballfan.ui.news.NewsFragment
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.fragment_leaguelist.*
import kotlinx.android.synthetic.main.fragment_main.view.*

class DetailMainFragment : RainbowCakeFragment<DetailMainViewState,DetailMainViewModel>() {
    companion object {
        private const val ARG_LEAGUE_ID = "ARG_LEAGUE_ID"

        fun newInstance(leagueID: String): DetailMainFragment {
            return DetailMainFragment().applyArgs {
                putString(ARG_LEAGUE_ID, leagueID)
            }
        }
    }

    private var leagueID: Int = 0
    override fun provideViewModel(): DetailMainViewModel = getViewModelFromFactory()
    override fun getViewResource(): Int = R.layout.fragment_leaguemaindetails


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initArgs()
    }

    private fun initArgs() {
        leagueID = requireArguments().requireString(ARG_LEAGUE_ID).toInt()
        Log.d("asd",leagueID.toString())
    }

    override fun render(viewState: DetailMainViewState) {
        when(viewState){
            Initial -> {
                testText.text = leagueID.toString()
            }
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_leaguemaindetails, container, false)
        initViewPager2WithFragments(view)
        return view
    }

    private fun initViewPager2WithFragments(view: View) {
        val adapter = ViewPagerAdapter(childFragmentManager, lifecycle)
        adapter.fragments = arrayListOf(BlankFragment(), BlankFragment(), BlankFragment())
        view.viewpager.adapter = adapter
        val names:Array<String> = arrayOf("fragment1","fragment2","fragmnet3")
        TabLayoutMediator(view.tablayout, view.viewpager){
            tab, position ->
            tab.text = names[position]
        }.attach()
    }
}
