package com.mvvmarch.secondchance.model.repo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.mvvmarch.secondchance.model.entities.CharactersItem
import com.mvvmarch.secondchance.model.local.CharactersDao
import com.mvvmarch.secondchance.model.local.CharactersDatabase
import com.mvvmarch.secondchance.model.remote.ApiService
import com.mvvmarch.secondchance.model.remote.RemoteDataSource
import com.mvvmarch.secondchance.utils.performGetOperation
import javax.inject.Inject

class CharactersRepository @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: CharactersDao
){

//    val allCharacters: LiveData<List<CharactersItem>> = charactersDao.getCharacters()
//
//    private val charLiveData = MutableLiveData<CharactersItem>()

//    val character: LiveData<CharactersItem>
//        get() = charLiveData

    fun getCharacters() = performGetOperation(
        databaseQuery = { localDataSource.getCharacters() },
        networkCall = { remoteDataSource.getCharacters() },
        saveCallResult = { localDataSource.insertCharacters(it)}
    )

    fun getCharacter(name: String) = performGetOperation(
        databaseQuery = { localDataSource.getCharacter(name) },
        networkCall = { remoteDataSource.getCharacter(name) },
        saveCallResult = { localDataSource.insert(it) }
    )

}
