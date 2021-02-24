package com.footballfan.ui.register

import co.zsmb.rainbowcake.withIOContext
import com.footballfan.RegisterInteractor
import javax.inject.Inject

class RegisterPresenter @Inject constructor(
    private val registerInteractor: RegisterInteractor
    ){
    suspend fun getData(): String = withIOContext {
        ""
    }

    suspend fun saveUser(email : String, password : String) : Boolean = withIOContext {
        registerInteractor.saveUser(email.trim{it <= ' '},password.trim{it <= ' '})
    }
}
