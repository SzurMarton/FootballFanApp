package com.footballfan

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase
import javax.inject.Inject


class RegisterInteractor @Inject constructor(){
    suspend fun saveUser(email : String, password: String,username: String) : Boolean {
        //return FirebaseAuth.getInstance().createUserWithEmailAndPassword(email,password).isSuccessful
        //TODO fix return for events, return boolean correctly after creation and db save
        //TODO save user to database
        /*
            FirebaseAuth.getInstance().createUserWithEmailAndPassword(email,password).addOnCompletelistener{
                task ->
                if (task.issuccesfull) return true
            }
         */
        //val uid =  FirebaseAuth.getInstance().uid ?: ""
        //FirebaseDatabase.getInstance().reference.setValue(User(uid,username))
        //val uid = "CqBwq4pUsuQ1erL8n4taTvXpwNd2"
        //FirebaseDatabase.getInstance().getReference("useres/$uid").setValue(User(uid,"asd"))
        return true
    }

    data class User(
            val uid: String,
            val username: String
    )
}