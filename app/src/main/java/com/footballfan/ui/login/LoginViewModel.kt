package com.footballfan.ui.login

import co.zsmb.rainbowcake.base.OneShotEvent
import co.zsmb.rainbowcake.base.RainbowCakeViewModel
import javax.inject.Inject

class LoginViewModel @Inject constructor(private val loginPresenter: LoginPresenter)
    : RainbowCakeViewModel<LoginViewState>(ViewReady){

    object LoginSuccessEvent : OneShotEvent
    class LoginFailedEvent(val errorMessages:String) : OneShotEvent

    fun login(email:String,password: String) = execute {
        val result = loginPresenter.login(email,password)
        if (result){
            postEvent(LoginSuccessEvent)
        }
        else{
            postEvent(LoginFailedEvent("Login failed pls try again"))
        }
    }
}