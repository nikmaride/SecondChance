package com.mvvmarch.secondchance.model.remote

import com.mvvmarch.secondchance.model.entities.CharactersItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("characters")
    suspend fun getAllCharacters() : Response<List<CharactersItem>>

    @GET("characters/{name}")
    suspend fun getCharacter(@Path("name") name: String) : Response<CharactersItem>
}