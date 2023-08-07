package com.alternova.lego.di

import com.alternova.lego.data.datasource.login.LoginDataSource
import com.alternova.lego.data.datasource.login.LoginDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {

    @Binds
    abstract fun bindLoginDataSource(loginDataSourceImpl: LoginDataSourceImpl) : LoginDataSource


}