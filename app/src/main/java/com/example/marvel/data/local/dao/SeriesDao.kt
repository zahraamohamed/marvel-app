package com.example.marvel.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.marvel.data.local.entity.CreatorEntity
import com.example.marvel.data.local.entity.SeriesEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface SeriesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSeries(item: List<SeriesEntity>)

    @Query("Select * from Marvel_Series")
    fun getSeries(): Flow<List<SeriesEntity>>
}
