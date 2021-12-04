package com.example.marvel.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.marvel.data.local.entity.ComicsEntity

@Dao
interface ComicsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertComics(item: List<ComicsEntity>)

    @Query("Select * from Marvel_Comics")
    suspend fun getComics(): List<ComicsEntity>
}