package com.footballfan.domain

import android.content.ContentValues.TAG
import android.util.Log
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import javax.inject.Inject


class RegisterInteractor @Inject constructor(){
    suspend fun saveUser(email : String, password: String,username: String) : Task<AuthResult> {
         return FirebaseAuth.getInstance().createUserWithEmailAndPassword(email,password).addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d(TAG, "signInWithEmail:success")
                    val uid =  FirebaseAuth.getInstance().uid ?: ""
                    FirebaseDatabase.getInstance().reference.setValue(User(uid, username))

                } else {
                    // If sign in fails, display a message to the user.
                    Log.w(TAG, "signInWithEmail:failure", task.exception)

                }
              return@addOnCompleteListener
          }
    }

    data class User(
            val uid: String,
            val username: String
    )
}


