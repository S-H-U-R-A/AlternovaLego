package com.alternova.lego.di

import android.content.Context
import androidx.room.Room
import com.alternova.lego.data.local.database.LegoDataBase
import com.alternova.lego.data.local.database.dao.ShoppingCarDao
import com.alternova.lego.data.local.database.dao.UserDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataBaseModule {

    @Singleton
    @Provides
    fun provideDataBase(
        @ApplicationContext context: Context
    ): LegoDataBase {
        return synchronized(context){
            Room.databaseBuilder(
                context,
                LegoDataBase::class.java,
                LegoDataBase.DATABASE_NAME
            ).build()
        }
    }

    @Singleton
    @Provides
    fun provideUserDao(dataBase: LegoDataBase) : UserDao = dataBase.userDao()

    @Singleton
    @Provides
    fun provideShoppingCar(dataBase: LegoDataBase) : ShoppingCarDao = dataBase.shoppingCarDao()

}