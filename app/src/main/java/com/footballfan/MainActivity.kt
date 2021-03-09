package com.footballfan

import android.os.Bundle
import co.zsmb.rainbowcake.navigation.SimpleNavActivity
import com.footballfan.ui.BlankFragment
import com.footballfan.ui.login.LoginFragment
import com.footballfan.ui.main.MainFragment
import com.footballfan.ui.news.NewsFragment

import com.footballfan.ui.register.RegisterFragment

class MainActivity : SimpleNavActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            navigator.add(NewsFragment())
        }
    }

}