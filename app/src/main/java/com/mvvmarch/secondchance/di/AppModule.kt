package com.mvvmarch.secondchance.di

import android.content.Context
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.mvvmarch.secondchance.model.local.CharactersDatabase
import com.mvvmarch.secondchance.model.remote.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideRetrofit(): Retrofit =
        Retrofit.Builder()
            .baseUrl("https://futuramaapi.herokuapp.com/api/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    fun provideGson(): Gson = GsonBuilder().create()


    @Provides
    fun provideApiService(retrofit: Retrofit): ApiService = retrofit.create(ApiService::class.java)

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext appContext: Context) = CharactersDatabase.getDatabase(appContext)

    @Singleton
    @Provides
    fun provideCharacterDao(db: CharactersDatabase) = db.charactersDao()

}