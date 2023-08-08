package com.alternova.lego.data.datasource.login.database

import com.alternova.lego.data.local.database.dao.UserDao
import com.alternova.lego.data.local.database.entity.UserEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LoginDataBaseDataSourceImpl @Inject constructor(
    private val userDao: UserDao
) : LoginDataBaseDataSource {

    override suspend fun insertUser(user: UserEntity) = userDao.insertUser(user)


    override fun getUserById(idUser: String): Flow<UserEntity> = userDao.getUserById(idUser)

}