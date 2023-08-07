package com.alternova.lego.di

import com.alternova.lego.di.qualifiers.DefaultDispatcher
import com.alternova.lego.di.qualifiers.IoDispatcher
import com.alternova.lego.di.qualifiers.MainDispatcher
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers


@Module
@InstallIn(SingletonComponent::class)
object CoroutineModule {

    @IoDispatcher
    @Provides
    fun provideDispatcherIo() : CoroutineDispatcher = Dispatchers.IO

    @DefaultDispatcher
    @Provides
    fun provideDispatcherDefault() : CoroutineDispatcher = Dispatchers.Default

    @MainDispatcher
    @Provides
    fun provideDispatcherMain() : CoroutineDispatcher = Dispatchers.Main


}
