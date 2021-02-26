package com.footballfan.ui.register

import co.zsmb.rainbowcake.base.OneShotEvent
import co.zsmb.rainbowcake.base.RainbowCakeViewModel
import com.footballfan.ui.BlankReady
import com.google.android.gms.tasks.OnCompleteListener
import javax.inject.Inject

class RegisterViewModel @Inject constructor(private val registerPresenter : RegisterPresenter)
    :  RainbowCakeViewModel<RegisterViewState>(Loading)
{
    fun load() = execute {
        viewState = RegisterReady(registerPresenter.getData())
    }

    object NavigateSuccessEvent : OneShotEvent
    class NavigateFailureEvent(val errorMessage: String) : OneShotEvent
    object InputFailureEvent : OneShotEvent

    fun saveUser(email:String,password: String,username : String) = execute {
        if(email.isNullOrEmpty() || password.isNullOrEmpty() || username.isNullOrEmpty()){
            //TODO make this better
            postEvent(InputFailureEvent)
        }
        registerPresenter.saveUser(email,password,username).addOnCompleteListener { task ->
            if (task.isSuccessful){
                postEvent(NavigateSuccessEvent)
            } else{
                postEvent(NavigateFailureEvent("Registration failed please try again"))
            } }

    }
}
