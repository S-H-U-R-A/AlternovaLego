package com.alternova.lego.domain.repository.login

import com.alternova.lego.domain.model.UserDomain
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.flow.Flow

interface LoginRepository {

    suspend fun signInUser(user: String, password: String) : FirebaseUser?

    suspend fun signUpUser(user: String, password: String) : FirebaseUser?

    suspend fun isCurrentSession(): Boolean

    suspend fun insertUser(user: UserDomain)

    suspend fun getCurrentUserId() : String?

    fun getUserById(idUser: String): Flow<UserDomain>

}