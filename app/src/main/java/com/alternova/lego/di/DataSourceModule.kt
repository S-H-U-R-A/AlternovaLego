package com.alternova.lego.di

import com.alternova.lego.data.datasource.home.products.ProductNetworkDataSource
import com.alternova.lego.data.datasource.home.products.ProductNetworkDataSourceImpl
import com.alternova.lego.data.datasource.login.database.LoginDataBaseDataSource
import com.alternova.lego.data.datasource.login.database.LoginDataBaseDataSourceImpl
import com.alternova.lego.data.datasource.login.network.LoginNetworkDataSource
import com.alternova.lego.data.datasource.login.network.LoginNetworkDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {

    @Binds
    abstract fun bindLoginNetworkDataSource(loginDataSourceImpl: LoginNetworkDataSourceImpl) : LoginNetworkDataSource

    @Binds
    abstract fun bindProductNetworkDataSource( productNetworkDataSourceImpl: ProductNetworkDataSourceImpl ) : ProductNetworkDataSource


    @Binds
    abstract fun bindLoginDataBaseDataSource( loginDataBaseDataSourceImpl: LoginDataBaseDataSourceImpl ) : LoginDataBaseDataSource


}