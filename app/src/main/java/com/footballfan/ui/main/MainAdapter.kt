package com.footballfan.ui.main

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.footballfan.ui.BlankFragment
import com.footballfan.ui.news.NewsFragment

class MainAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
        FragmentStateAdapter(fragmentManager, lifecycle) {

    val fragments:ArrayList<Fragment> = arrayListOf(
            BlankFragment(),
            NewsFragment(),
            BlankFragment()
    )

    override fun getItemCount(): Int {
        return fragments.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragments[position]
    }
}