package com.alternova.lego.data.datasource.login

import android.util.Log
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class LoginDataSourceImpl @Inject constructor (
    private val firebaseAuth: FirebaseAuth
) : LoginDataSource {

    //SIGN IN USER
    override suspend fun signInUser(email: String, password: String) : FirebaseUser? {
        val user: Task<AuthResult> = firebaseAuth.signInWithEmailAndPassword(email, password)
        try {
            val userTask: AuthResult = user.await()
            Log.d("SUCCESS", userTask.user.toString())
            return userTask.user
        }catch(exception: Exception) {
            Log.d("ERROR_USER_SIGN_IN", exception.message.toString())
        }
        return null
    }


    //SIGN UP USER
    override suspend fun signUpUser(email: String, password: String) : FirebaseUser? {
        val user: Task<AuthResult> = firebaseAuth.createUserWithEmailAndPassword(email, password)
        try {
            val userTask: AuthResult = user.await()
            Log.d("SUCCESS", userTask.user.toString())
            return userTask.user
        }catch(exception: Exception) {
            Log.d("ERROR_USER_SIGN_IN", exception.message.toString())
        }
        return null
    }

    override suspend fun signOut() {
        firebaseAuth.signOut()
    }

}