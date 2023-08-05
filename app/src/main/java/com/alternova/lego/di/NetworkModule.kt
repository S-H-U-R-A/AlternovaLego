package com.alternova.lego.di

import com.alternova.lego.data.remote.retrofit.LegoApiServices
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Singleton
    @Provides
    fun provideInterceptor() : HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
        this.level = HttpLoggingInterceptor.Level.BODY
    }

    @Singleton
    @Provides
    fun provideClient(interceptor: HttpLoggingInterceptor) : OkHttpClient = OkHttpClient.Builder().apply {
        this.addInterceptor(interceptor)
    }.build()

    @Singleton
    @Provides
    fun provideLegoService( client: OkHttpClient ): LegoApiServices = Retrofit.Builder()
        .baseUrl("https://us-central1-api-back-admission-test.cloudfunctions.net/")
        .addConverterFactory(
            GsonConverterFactory.create()
        )
        .client(client)
        .build()
        .create(LegoApiServices::class.java)

}