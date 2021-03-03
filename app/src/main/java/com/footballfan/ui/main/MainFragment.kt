package com.footballfan.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import co.zsmb.rainbowcake.base.RainbowCakeFragment
import co.zsmb.rainbowcake.dagger.getViewModelFromFactory
import com.footballfan.R
import com.footballfan.ui.main.ViewReady
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.fragment_main.*
import kotlinx.android.synthetic.main.fragment_main.view.*

class MainFragment : RainbowCakeFragment<MainViewState,MainViewModel>() {
    override fun provideViewModel(): MainViewModel = getViewModelFromFactory()
    override fun getViewResource(): Int = R.layout.activity_main
    private var v : View? = null
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
        view.viewpager.adapter = MainAdapter(childFragmentManager,lifecycle)
        var names:Array<String> = arrayOf("1","2","3")
        TabLayoutMediator(view.tablayout, view.viewpager){
            tab, position ->
            tab.text = names[position]
        }.attach()
    }

}