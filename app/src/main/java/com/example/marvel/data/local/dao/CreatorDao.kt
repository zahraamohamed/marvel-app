package com.example.marvel.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.marvel.data.local.entity.CreatorEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface CreatorDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCreator(item: List<CreatorEntity>)

    @Query("Select * from Marvel_Creator")
    fun getCreator(): Flow<List<CreatorEntity>>
}