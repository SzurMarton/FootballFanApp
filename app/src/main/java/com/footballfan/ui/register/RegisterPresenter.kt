package com.footballfan.ui.register

import co.zsmb.rainbowcake.withIOContext
import com.footballfan.RegisterInteractor
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import javax.inject.Inject

class RegisterPresenter @Inject constructor(
    private val registerInteractor: RegisterInteractor
    ){

    suspend fun saveUser(email : String, password : String,username:String) : Task<AuthResult> = withIOContext {
        registerInteractor.saveUser(email.trim{it <= ' '},password.trim{it <= ' '},username.trim{it <= ' '})
    }
}
