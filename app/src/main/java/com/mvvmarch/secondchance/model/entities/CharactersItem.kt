package com.mvvmarch.secondchance.model.entities

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity (tableName = "characters_table")
data class CharactersItem(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val Name: String,
    val Age: String,
    val FirstAppearance: String,
    val PicUrl: String,
    val Planet: String,
    val Profession: String,
    val Relatives: String,
    val Species: String,
    val Status: String,
    val VoicedBy: String
)