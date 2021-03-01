package com.footballfan.ui.login

import co.zsmb.rainbowcake.base.OneShotEvent
import co.zsmb.rainbowcake.base.RainbowCakeViewModel
import com.footballfan.R
import javax.inject.Inject

class LoginViewModel @Inject constructor(private val loginPresenter: LoginPresenter)
    : RainbowCakeViewModel<LoginViewState>(ViewReady){

    object LoginSuccessEvent : OneShotEvent
    class LoginFailedEvent(val errorMessages:String) : OneShotEvent

    fun login(email:String,password: String) = execute {
        loginPresenter.login(email,password).addOnCompleteListener{task ->
            if (task.isSuccessful){
                postEvent(LoginSuccessEvent)
            }
            else{
                postEvent(LoginFailedEvent(R.string.loginFailed.toString()))
            }
        }

    }
}