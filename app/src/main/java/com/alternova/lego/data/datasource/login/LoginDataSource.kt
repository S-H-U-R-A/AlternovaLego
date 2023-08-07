package com.alternova.lego.data.datasource.login


import com.google.firebase.auth.FirebaseUser

interface LoginDataSource{

    suspend fun signInUser(email: String, password: String) : FirebaseUser?

    suspend fun signUpUser(email: String, password: String) : FirebaseUser?

    suspend fun signOut() : Unit

}