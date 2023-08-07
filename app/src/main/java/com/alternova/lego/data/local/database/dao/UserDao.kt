package com.alternova.lego.data.local.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.alternova.lego.data.local.database.entity.UserEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: UserEntity)

    @Query(
        """
        SELECT * FROM ${UserEntity.TABLE_NAME} WHERE id = :idUser
        """
    )
    fun getUserById(idUser: String): Flow<UserEntity>

}