package com.mvvmarch.secondchance.model.remote

import javax.inject.Inject

class RemoteDataSource @Inject constructor(
    private val characterService: ApiService
): BaseDataSource() {

    suspend fun getCharacters() = getResult { characterService.getAllCharacters() }
    suspend fun getCharacter(name: String) = getResult { characterService.getCharacter(name) }
}