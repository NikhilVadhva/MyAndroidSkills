package com.example.myandroidskills.di

import com.example.myandroidskills.model.api.ApiService
import com.example.myandroidskills.utils.Constant
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton
@InstallIn (SingletonComponent::class)
@Module
class NetworkModule {
    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit
    {
         return  Retrofit.Builder().baseUrl(Constant.BASE_URL)
             .addConverterFactory(GsonConverterFactory.create())
             .build()
    }

    @Singleton
    @Provides
    fun provideAPIService(retrofit: Retrofit) : ApiService
    {
         return  retrofit.create(ApiService::class.java)
    }

}