package com.alternova.lego.di

import com.alternova.lego.data.repository.home.products.ProductRepository
import com.alternova.lego.data.repository.login.LoginRepository
import com.alternova.lego.domain.repository.home.products.ProductRepositoryImpl
import com.alternova.lego.domain.repository.login.LoginRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindLoginRepository( loginRepositoryImpl: LoginRepositoryImpl ) : LoginRepository


    @Binds
    abstract fun bindProductRepository( productRepositoryImpl: ProductRepositoryImpl ) : ProductRepository

}