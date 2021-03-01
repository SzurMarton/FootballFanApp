package com.footballfan

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
            /*if (task.isSuccessful) {
                // Sign in success, update UI with the signed-in user's information
                Log.d(ContentValues.TAG, "signInWithEmail:success")
            } else {
                // If sign in fails, display a message to the user.
                Log.w(ContentValues.TAG, "signInWithEmail:failure", task.exception)

            }*/
            return@addOnCompleteListener
        }
    }
}