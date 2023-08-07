package com.alternova.lego.data.datasource.login.network


import com.google.firebase.auth.FirebaseUser

interface LoginNetworkDataSource{

    suspend fun signInUser(email: String, password: String) : FirebaseUser?

    suspend fun signUpUser(email: String, password: String) : FirebaseUser?

    suspend fun getCurrentUserId() : String?

    suspend fun isCurrentSession() : Boolean

    suspend fun signOut() : Unit

}