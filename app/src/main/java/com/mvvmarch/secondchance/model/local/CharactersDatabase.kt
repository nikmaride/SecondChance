package com.mvvmarch.secondchance.model.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.mvvmarch.secondchance.model.entities.CharactersItem


@Database(entities = [CharactersItem::class], version = 2)
abstract class CharactersDatabase:RoomDatabase() {

    abstract fun charactersDao(): CharactersDao

    companion object{
    @Volatile
    private var INSTANCE: CharactersDatabase? = null


        fun getDatabase(context: Context): CharactersDatabase{
            return (INSTANCE?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    CharactersDatabase::class.java,
                    "characters_database"
                ).fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                instance
            }) as CharactersDatabase
        }
    }
}