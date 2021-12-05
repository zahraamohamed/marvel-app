package com.example.marvel.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.marvel.data.local.entity.CharacterDetailsEntity

@Dao
interface CharacterDetailsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCharactersDetails(item: List<CharacterDetailsEntity>)

    @Query("Select * from Marvel_Character")
    suspend fun getCharactersDetails(): List<CharacterDetailsEntity>
}