package com.alternova.lego.data.repository.login

import com.alternova.lego.data.local.database.entity.UserEntity
import com.alternova.lego.domain.model.UserDomain
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.flow.Flow

interface LoginRepository {

    suspend fun signInUser(user: String, password: String) : FirebaseUser?

    suspend fun signUpUser(user: String, password: String) : FirebaseUser?

    suspend fun isCurrentSession(): Boolean

    suspend fun insertUser(user: UserDomain)

    fun getUserById(idUser: String): Flow<UserDomain>

}