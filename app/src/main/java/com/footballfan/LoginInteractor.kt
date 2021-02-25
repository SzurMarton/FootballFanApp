package com.footballfan

import com.google.firebase.auth.FirebaseAuth
import javax.inject.Inject

class LoginInteractor @Inject constructor(){
    suspend fun login(email: String, password: String) : Boolean {
        FirebaseAuth.getInstance().signInWithEmailAndPassword(email,password)
        //TODO fix return to return the boolean correctly
        return true
    }
}