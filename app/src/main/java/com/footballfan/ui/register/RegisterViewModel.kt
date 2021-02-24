package com.footballfan.ui.register

import co.zsmb.rainbowcake.base.OneShotEvent
import co.zsmb.rainbowcake.base.RainbowCakeViewModel
import com.footballfan.ui.BlankReady
import javax.inject.Inject

class RegisterViewModel @Inject constructor(private val registerPresenter : RegisterPresenter)
    :  RainbowCakeViewModel<RegisterViewState>(Loading)
{
    fun load() = execute {
        viewState = RegisterReady(registerPresenter.getData())
    }

    object NavigateSuccessEvent : OneShotEvent
    class NavigateFailureEvent(val errorMessage: String) : OneShotEvent

    fun saveUser(email:String,password: String) = execute {
        val result = registerPresenter.saveUser(email,password)
        if (result){
            postEvent(NavigateSuccessEvent)
        }
        else{
           postEvent(NavigateFailureEvent("Registration failed please try again"))
        }
        viewState = RegisterReady(registerPresenter.getData())
    }
}
