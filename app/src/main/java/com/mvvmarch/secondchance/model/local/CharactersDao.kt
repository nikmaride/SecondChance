package com.mvvmarch.secondchance.model.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mvvmarch.secondchance.model.entities.CharactersItem
import dagger.Provides


@Dao
interface CharactersDao {

    @Query("SELECT * FROM characters_table")
     fun getCharacters():LiveData<List<CharactersItem>>

    @Query("SELECT * FROM characters_table WHERE Name = :name")
    fun getCharacter(name: String):LiveData<CharactersItem>

    @Insert
    suspend fun insertCharacters(character: List<CharactersItem>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(character:CharactersItem)


}