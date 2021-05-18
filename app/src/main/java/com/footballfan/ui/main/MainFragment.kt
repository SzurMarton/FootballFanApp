package com.footballfan.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import co.zsmb.rainbowcake.base.RainbowCakeFragment
import co.zsmb.rainbowcake.dagger.getViewModelFromFactory
import com.footballfan.R
import com.footballfan.ui.BlankFragment
import com.footballfan.ui.ViewPagerAdapter
import com.footballfan.ui.blog.BlogFragment
import com.footballfan.ui.football.leaguelist.LeagueListFragment
import com.footballfan.ui.news.newslist.NewsFragment
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.fragment_main.view.*

class MainFragment : RainbowCakeFragment<MainViewState,MainViewModel>() {
    override fun provideViewModel(): MainViewModel = getViewModelFromFactory()
   // override fun getViewResource(): Int = R.layout.activity_main
    override fun getViewResource(): Int = R.layout.fragment_main
    override fun render(viewState: MainViewState) {
        when(viewState){
            ViewReady -> {}
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_main, container, false)
        initViewPager2WithFragments(view)
        return view
    }

    private fun initViewPager2WithFragments(view: View){
        val adapter = ViewPagerAdapter(childFragmentManager, lifecycle)
        adapter.fragments = arrayListOf(LeagueListFragment(), NewsFragment(), BlogFragment())
        view.viewpager.adapter = adapter
        val names:Array<String> = arrayOf(getString(R.string.mainTabLeagues),getString(R.string.mainTabNews),getString(R.string.mainTabForum))
        TabLayoutMediator(view.tablayout, view.viewpager){
            tab, position ->
            tab.text = names[position]
        }.attach()
    }
}