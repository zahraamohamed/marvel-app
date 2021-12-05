package com.example.marvel.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.marvel.data.local.entity.EventEntity


@Dao
interface EventDao {


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertEvent(item: List<EventEntity>)

    @Query("Select * from Marvel_Event")
    suspend fun getEvent(): List<EventEntity>
}