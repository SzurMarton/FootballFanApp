package com.footballfan.domain

import android.content.ContentValues
import android.util.Log
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import javax.inject.Inject

class LoginInteractor @Inject constructor(){
    suspend fun login(email: String, password: String) : Task<AuthResult> {
        return FirebaseAuth.getInstance().signInWithEmailAndPassword(email,password).addOnCompleteListener {
            return@addOnCompleteListener
        }
    }
}