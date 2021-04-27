package com.footballfan.ui.auth.login

import co.zsmb.rainbowcake.withIOContext
import com.footballfan.domain.LoginInteractor
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import javax.inject.Inject

class LoginPresenter @Inject constructor(
    private val logininteractor : LoginInteractor
){
    suspend fun login(email: String,password : String): Task<AuthResult> = withIOContext{
        logininteractor.login(email.trim{it <= ' '},password.trim{it <= ' '})
    }
}