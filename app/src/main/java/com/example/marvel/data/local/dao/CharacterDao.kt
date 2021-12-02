package com.example.marvel.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.marvel.data.local.entity.CharacterEntity
import kotlinx.coroutines.flow.Flow


@Dao
interface CharacterDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCharacters(item: List<CharacterEntity>)


    @Query("Select * from Marvel_Character")
    fun getCharacters(): Flow<CharacterEntity>
}