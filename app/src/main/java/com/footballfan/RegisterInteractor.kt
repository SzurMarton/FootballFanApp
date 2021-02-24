package com.footballfan

import javax.inject.Inject


class RegisterInteractor @Inject constructor(){
    suspend fun saveUser(email : String, password: String) : Boolean{
        //return FirebaseAuth.getInstance().createUserWithEmailAndPassword(email,password).isSuccessful
        //FirebaseAuth.getIns
        return true
    }
}