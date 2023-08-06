package com.alternova.lego.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.alternova.lego.data.local.database.dao.ShoppingCarDao
import com.alternova.lego.data.local.database.dao.UserDao
import com.alternova.lego.data.local.database.entity.ShoppingCarEntity
import com.alternova.lego.data.local.database.entity.UserEntity


@Database(
    entities = [
        UserEntity::class,
        ShoppingCarEntity::class
    ],
    version = LegoDataBase.DATABASE_VERSION,
    exportSchema = false
)
abstract class LegoDataBase : RoomDatabase() {

    companion object {
        const val DATABASE_VERSION = 1
        const val DATABASE_NAME = "lego_database"
    }

    abstract fun userDao() : UserDao
    abstract fun shoppingCarDao() : ShoppingCarDao

}