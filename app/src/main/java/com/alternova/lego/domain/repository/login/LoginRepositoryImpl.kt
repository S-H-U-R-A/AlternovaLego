package com.alternova.lego.domain.repository.login

import com.alternova.lego.data.datasource.login.LoginDataSource
import com.alternova.lego.data.repository.login.LoginRepository
import com.alternova.lego.di.qualifiers.IoDispatcher
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class LoginRepositoryImpl @Inject constructor (
    private val loginDataSource: LoginDataSource,
    @IoDispatcher private val coroutineDispatcher: CoroutineDispatcher
) : LoginRepository {
    override suspend fun signInUser(user: String, password: String): FirebaseUser? = withContext(coroutineDispatcher){
        loginDataSource.signInUser(user, password)
    }

    override suspend fun signUpUser(user: String, password: String): FirebaseUser? = withContext( coroutineDispatcher){
        loginDataSource.signUpUser(user, password)
    }

}