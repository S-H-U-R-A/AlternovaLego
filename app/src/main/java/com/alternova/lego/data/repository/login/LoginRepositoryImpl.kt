package com.alternova.lego.data.repository.login

import com.alternova.lego.data.datasource.login.database.LoginDataBaseDataSource
import com.alternova.lego.data.datasource.login.network.LoginNetworkDataSource
import com.alternova.lego.domain.repository.login.LoginRepository
import com.alternova.lego.di.qualifiers.IoDispatcher
import com.alternova.lego.domain.model.UserDomain
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import javax.inject.Inject

class LoginRepositoryImpl @Inject constructor (
    private val loginNetworkDataSource: LoginNetworkDataSource,
    private val loginDataBaseDataSource: LoginDataBaseDataSource,
    @IoDispatcher private val coroutineDispatcher: CoroutineDispatcher
) : LoginRepository {

    override suspend fun signInUser(user: String, password: String): FirebaseUser? = withContext(coroutineDispatcher){
        loginNetworkDataSource.signInUser(user, password)
    }

    override suspend fun signUpUser(user: String, password: String): FirebaseUser? = withContext( coroutineDispatcher){
        loginNetworkDataSource.signUpUser(user, password)
    }

    //COMPROBACIONES DE USUARIO  DEBEN BLOQUEAR EL MAIN
    override suspend fun isCurrentSession(): Boolean = loginNetworkDataSource.isCurrentSession()



    override suspend fun insertUser(user: UserDomain) = withContext(coroutineDispatcher){
        loginDataBaseDataSource.insertUser(user.toEntity())
    }

    override suspend fun getCurrentUserId(): String? = withContext(coroutineDispatcher){
        loginNetworkDataSource.getCurrentUserId()
    }

    override fun getUserById(idUser: String): Flow<UserDomain> {
        return loginDataBaseDataSource.getUserById(idUser).map { userEntity ->
            userEntity.toDomain()
        }
    }
}