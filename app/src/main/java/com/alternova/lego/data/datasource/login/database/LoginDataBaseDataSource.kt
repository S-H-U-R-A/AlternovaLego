package com.alternova.lego.data.datasource.login.database

import com.alternova.lego.data.local.database.entity.UserEntity
import kotlinx.coroutines.flow.Flow

interface LoginDataBaseDataSource {

    suspend fun insertUser(user: UserEntity)

    fun getUserById(idUser: String): Flow<UserEntity>

}