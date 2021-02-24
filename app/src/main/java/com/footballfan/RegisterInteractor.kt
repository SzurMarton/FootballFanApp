package com.footballfan

import com.google.firebase.auth.FirebaseAuth
import javax.inject.Inject


class RegisterInteractor @Inject constructor(){
    suspend fun saveUser(email : String, password: String) : Boolean{
        return FirebaseAuth.getInstance().createUserWithEmailAndPassword(email,password).isSuccessful
    }
}