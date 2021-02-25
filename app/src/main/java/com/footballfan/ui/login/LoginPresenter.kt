package com.footballfan.ui.login

import android.provider.ContactsContract
import co.zsmb.rainbowcake.withIOContext
import com.footballfan.LoginInteractor
import javax.inject.Inject

class LoginPresenter @Inject constructor(
    private val logininteractor : LoginInteractor
){
    suspend fun login(email: String,password : String): Boolean = withIOContext{
        logininteractor.login(email.trim{it <= ' '},password.trim{it <= ' '})
    }
}