package com.footballfan.di

import androidx.lifecycle.ViewModel
import co.zsmb.rainbowcake.dagger.ViewModelKey
import com.footballfan.ui.BlankViewModel
import com.footballfan.ui.deatilnews.DetailNewsViewModel
import com.footballfan.ui.leaguedetailmain.DetailMainViewModel
import com.footballfan.ui.leaguelist.LeagueListViewModel
import com.footballfan.ui.login.LoginViewModel
import com.footballfan.ui.main.MainViewModel
import com.footballfan.ui.news.NewsViewModel
import com.footballfan.ui.register.RegisterViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Suppress("unused")
@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(BlankViewModel::class)
    abstract fun bindBlankViewModel(blankViewModel: BlankViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(RegisterViewModel::class)
    abstract fun bindRegisterViewModel(registerViewModel: RegisterViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(LoginViewModel::class)
    abstract fun bindLoginViewModel(loginViewModel: LoginViewModel) : ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindMainViewModel(mainViewModel: MainViewModel) : ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(NewsViewModel::class)
    abstract fun bindNewsViewModel(newsViewModel: NewsViewModel) : ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(DetailNewsViewModel::class)
    abstract fun bindDetailNewsViewModel(detailNewsViewModel: DetailNewsViewModel) : ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(LeagueListViewModel::class)
    abstract fun bindLeagueListViewModel(leagueListViewModel: LeagueListViewModel) : ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(DetailMainViewModel::class)
    abstract fun bindDetailMainViewModel(deatailMainViewModel: DetailMainViewModel) : ViewModel
}
