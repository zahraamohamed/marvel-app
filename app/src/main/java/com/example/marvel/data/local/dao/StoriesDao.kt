package com.example.marvel.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.marvel.data.local.entity.StoriesEntity

@Dao
interface StoriesDao {


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStories(item: List<StoriesEntity>)

    @Query("Select * from Marvel_Stories")
    suspend fun getStories(): List<StoriesEntity>
}