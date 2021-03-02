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

class MainFragment : RainbowCakeFragment<MainViewState,MainViewModel>() {
    override fun provideViewModel(): MainViewModel = getViewModelFromFactory()
    override fun getViewResource(): Int = R.layout.activity_main

    override fun render(viewState: MainViewState) {
        when(viewState){
            ViewReady -> {}
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater.inflate(R.layout.fragment_blank, container, false)

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initViewPager2WithFragments()
    }

    private fun initViewPager2WithFragments(){
        viewpager.adapter = MainAdapter(childFragmentManager,lifecycle)

        //var tabLayout:TabLayout = findViewById(R.id.tablayout)
        var names:Array<String> = arrayOf("1","2","3")
        TabLayoutMediator(tablayout,viewpager){
            tab, position ->
            tab.text = names[position]
        }.attach()
    }

}