package com.alternova.lego.data.repository.login

import com.google.firebase.auth.FirebaseUser

interface LoginRepository {

    suspend fun signInUser(user: String, password: String) : FirebaseUser?

    suspend fun signUpUser(user: String, password: String) : FirebaseUser?

}