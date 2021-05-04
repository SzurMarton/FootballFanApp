package com.footballfan

import android.os.Bundle
import co.zsmb.rainbowcake.navigation.SimpleNavActivity
import com.footballfan.ui.auth.login.LoginFragment
import com.footballfan.ui.blog.BlogFragment
import com.footballfan.ui.football.leaguestandings.StandingsFragment
import com.footballfan.ui.football.lineups.LineupFragment
import com.footballfan.ui.main.MainFragment

class MainActivity : SimpleNavActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            navigator.add(BlogFragment())
        }
    }

}